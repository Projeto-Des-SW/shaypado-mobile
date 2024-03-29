package com.ufape.shaypado.ui.model

import androidx.annotation.StringRes

data class UserState(
    val name: String,
    val email: String,

    val fatPercentage: String?,
    val armCircumference: String?,
    val waistCircumference: String?,
    val abdomenCircumference: String?,
    val hipCircumference: String?,
    val thighCircumference: String?,
    val legCircumference: String?,
    val height: String?,
    val weight: String?,
    val age: String?,
    val shoulderCircumference: String?,
    val tricepsFold: String?,
    val bicepsFold: String?,
    val chestFold: String?,
    val axialFold: String?,
    val suprailiacFold: String?,
    val abdominalFold: String?,
    val thighFold: String?,
    val legFold: String?,
    val healthIssue: String?,
    val scapularFold: String?,
    val objective: String?,
    val exerciseExperience: Boolean?,
    val spineProblem: Boolean,
    val isSmoker: Boolean,
    val gender: String?,
)

data class UserWithWorkoutState(
    val user: UserState,
    val workouts: List<WorkoutState>
)

fun UserWithWorkoutState.getPhysicalData() = PhysicalFormState(
    name = user.name,
    fatPercentage = user.fatPercentage ?: "",
    armCircumference = user.armCircumference ?: "",
    waistCircumference = user.waistCircumference ?: "",
    abdomenCircumference = user.abdomenCircumference ?: "",
    hipCircumference = user.hipCircumference ?: "",
    thighCircumference = user.thighCircumference ?: "",
    legCircumference = user.legCircumference ?: "",
    height = user.height ?: "",
    weight = user.weight ?: "",
    age = user.age ?: "",
    shoulderCircumference = user.shoulderCircumference ?: "",
    tricepsFold = user.tricepsFold ?: "",
    bicepsFold = user.bicepsFold ?: "",
    chestFold = user.chestFold ?: "",
    axialFold = user.axialFold ?: "",
    suprailiacFold = user.suprailiacFold ?: "",
    abdominalFold = user.abdominalFold ?: "",
    thighFold = user.thighFold ?: "",
    legFold = user.legFold ?: "",
    healthIssue = user.healthIssue ?: "",
    scapularFold = user.scapularFold ?: "",
    objective = user.objective ?: "",
    exerciseExperience = user.exerciseExperience!!,
    spineProblem = user.spineProblem,
    isSmoker = user.isSmoker,
    gender = user.gender ?: ""
)

data class PhysicalFormState(
    val name: String = "",

    val fatPercentage: String = "",
    @StringRes val fatPercentageError: Int? = null,
    val armCircumference: String = "",
    @StringRes val armCircumferenceError: Int? = null,
    val waistCircumference: String = "",
    @StringRes val waistCircumferenceError: Int? = null,
    val abdomenCircumference: String = "",
    @StringRes val abdomenCircumferenceError: Int? = null,
    val hipCircumference: String = "",
    @StringRes val hipCircumferenceError: Int? = null,
    val thighCircumference: String = "",
    @StringRes val thighCircumferenceError: Int? = null,
    val legCircumference: String = "",
    @StringRes val legCircumferenceError: Int? = null,
    val height: String = "",
    @StringRes val heightError: Int? = null,
    val weight: String = "",
    @StringRes val weightError: Int? = null,
    val age: String = "",
    @StringRes val ageError: Int? = null,
    val shoulderCircumference: String = "",
    @StringRes val shoulderCircumferenceError: Int? = null,
    val tricepsFold: String = "",
    @StringRes val tricepsFoldError: Int? = null,
    val bicepsFold: String = "",
    @StringRes val bicepsFoldError: Int? = null,
    val chestFold: String = "",
    @StringRes val chestFoldError: Int? = null,
    val axialFold: String = "",
    @StringRes val axialFoldError: Int? = null,
    val suprailiacFold: String = "",
    @StringRes val suprailiacFoldError: Int? = null,
    val abdominalFold: String = "",
    @StringRes val abdominalFoldError: Int? = null,
    val thighFold: String = "",
    @StringRes val thighFoldError: Int? = null,
    val legFold: String = "",
    @StringRes val legFoldError: Int? = null,
    val healthIssue: String = "",
    @StringRes val healthIssueError: Int? = null,
    val scapularFold: String = "",
    @StringRes val scapularFoldError: Int? = null,
    val objective: String = "",
    @StringRes val objectiveError: Int? = null,
    val exerciseExperience: Boolean = false,
    @StringRes val exerciseExperienceError: Int? = null,
    val spineProblem: Boolean = false,
    @StringRes val spineProblemError: Int? = null,
    val isSmoker: Boolean = false,
    @StringRes val isSmokerError: Int? = null,
    val gender: String = "",
    @StringRes val genderError: Int? = null
)


