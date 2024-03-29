package com.ufape.shaypado.ui.screens.signUp

sealed class UserAccountFormEvent {
    data class OnNameChanged(val name: String) : UserAccountFormEvent()
    data class OnEmailChanged(val email: String) : UserAccountFormEvent()
    data class OnEmailConfirmationChanged(val emailConfirmation: String) : UserAccountFormEvent()
    data class OnPasswordChanged(val password: String) : UserAccountFormEvent()
    data class OnPasswordConfirmationChanged(val passwordConfirmation: String) : UserAccountFormEvent()
    data class OnCorporalDataChanged(val saveCorporalData: Boolean) : UserAccountFormEvent()
    data class OnTermsAcceptedChanged(val termsAccepted: Boolean) : UserAccountFormEvent()
    data class OnUserTypeChanged(val userType: String) : UserAccountFormEvent()

    data object ValidateUserData : UserAccountFormEvent()
    data object ValidateProfileData : UserAccountFormEvent()
    data object OnSubmit : UserAccountFormEvent()
}
