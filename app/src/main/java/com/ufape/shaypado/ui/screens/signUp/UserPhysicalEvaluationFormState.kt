package com.ufape.shaypado.ui.screens.signUp

import androidx.annotation.StringRes

data class UserPhysicalEvaluationFormState(
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
    val spineProblem: Boolean = false,
    val isSmoker: Boolean = false,
    val gender : String = "M",
    @StringRes val genderError: Int? = null
)
