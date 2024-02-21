package com.ufape.shaypado.ui.screens.signUp

sealed class UserPhysicalEvaluationFormEvent {
    data class OnFatPercentageChanged(val fatPercentage: String) : UserPhysicalEvaluationFormEvent()
    data class OnArmCircumferenceChanged(val armCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnWaistCircumferenceChanged(val waistCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnAbdomenCircumferenceChanged(val abdomenCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnHipCircumferenceChanged(val hipCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnThighCircumferenceChanged(val thighCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnLegCircumferenceChanged(val legCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnHeightChanged(val height: String) : UserPhysicalEvaluationFormEvent()
    data class OnWeightChanged(val weight: String) : UserPhysicalEvaluationFormEvent()
    data class OnAgeChanged(val age: String) : UserPhysicalEvaluationFormEvent()
    data class OnShoulderCircumferenceChanged(val shoulderCircumference: String) : UserPhysicalEvaluationFormEvent()
    data class OnTricepsFoldChanged(val tricepsFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnBicepsFoldChanged(val bicepsFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnChestFoldChanged(val chestFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnAxialFoldChanged(val axialFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnSuprailiacFoldChanged(val suprailiacFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnAbdominalFoldChanged(val abdominalFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnThighFoldChanged(val thighFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnLegFoldChanged(val legFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnHealthIssueChanged(val healthIssue: String) : UserPhysicalEvaluationFormEvent()
    data class OnExerciseExperienceChanged(val exerciseExperience: Boolean) : UserPhysicalEvaluationFormEvent()
    data class OnSpineProblemChanged(val hasSpineProblem: Boolean) : UserPhysicalEvaluationFormEvent()
    data class OnSmokerChanged(val isSmoker: Boolean) : UserPhysicalEvaluationFormEvent()
    data class OnScapularFoldChanged(val scapularFold: String) : UserPhysicalEvaluationFormEvent()
    data class OnObjectiveChanged(val objective: String) : UserPhysicalEvaluationFormEvent()

    data object OnSubmit : UserPhysicalEvaluationFormEvent()
}