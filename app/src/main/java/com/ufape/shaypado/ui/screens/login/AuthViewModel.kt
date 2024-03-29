package com.ufape.shaypado.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ufape.shaypado.data.model.LoginRequest
import com.ufape.shaypado.data.repositories.interfaces.IAuthRepository
import com.ufape.shaypado.ui.domain.use_case.hasError
import com.ufape.shaypado.ui.domain.use_case.validateEmail
import com.ufape.shaypado.util.ISafeNetworkHandler
import com.ufape.shaypado.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: IAuthRepository,
    private val handler: ISafeNetworkHandler
) : ViewModel() {
    var loginDataState by mutableStateOf(LoginFormState())

    private val _loggedInState = MutableStateFlow(LoggedState())
    val loggedInState = _loggedInState.asStateFlow()

    private val _sessionExpired = MutableStateFlow(false)
    val sessionExpired = _sessionExpired.asStateFlow()

    private val loginEventChannel = Channel<Result<LoggedState>>()
    val loginEvent = loginEventChannel.receiveAsFlow()

    init {
        val user = authRepository.fetchUser()
        _loggedInState.value = LoggedState(
            token = user?.token,
            userType = user?.userType,
        )
    }

    fun onLoginDataEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.OnEmailChanged -> {
                loginDataState = loginDataState.copy(email = event.email)
            }

            is LoginFormEvent.OnPasswordChanged -> {
                loginDataState = loginDataState.copy(password = event.password)
            }

            is LoginFormEvent.OnSubmit -> {
                login()
            }

        }
    }

    fun logout() {
        authRepository.logout()
        _loggedInState.value = LoggedState(
            token = null,
            userType = null,
        )
        _sessionExpired.value = false
    }

    fun sessionExpired() {
        _sessionExpired.value = true
    }

    private fun validate(): Boolean {
        val emailValidation = validateEmail(loginDataState.email)

        loginDataState = loginDataState.copy(
            emailError = emailValidation.error,
        )

        return hasError(
            emailValidation,
        )
    }

    fun login() {
        val hasError = validate()

        if (hasError) return

        viewModelScope.launch {
            val loginRequest = LoginRequest(
                email = loginDataState.email,
                password = loginDataState.password,
            )
            val result = handler.makeSafeApiCall {
                authRepository.login(loginRequest)
            }

            if (result is Result.Success) {
                _loggedInState.value = LoggedState(
                    token = result.data.token,
                    userType = result.data.userType,
                )
            } else if (result is Result.Error){
                loginEventChannel.send(result)
            }
        }
    }
}