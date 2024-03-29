package com.ufape.shaypado.ui.screens.trainer.createTrainings

import androidx.annotation.StringRes
import com.ufape.shaypado.data.model.CreateExerciseRequest
import com.ufape.shaypado.data.model.CreateWorkoutRequest
import com.ufape.shaypado.ui.model.ExerciseState

data class TrainingsFormState(
    val id: String ? = null,
    val name: String = "",
    @StringRes val nameError: Int? = null,
    val category: String = "",
    val categoryLabel : String = "",
    @StringRes val categoryError: Int? = null,
    var exercises: List<ExerciseFormState> = emptyList(),
)

data class ExerciseFormState(
    val id: String ? = null,
    val title: String = "",
    @StringRes val titleError: Int? = null,
    val description: String = "",
    @StringRes val descriptionError: Int? = null,
    val videoUrl : String = "",
    @StringRes val videoUrlError: Int? = null,
    val series : String = "0",
    @StringRes val seriesError: Int? = null,
    val repetitions : String = "0",
    @StringRes val repetitionsError: Int? = null,
    val time : String = "00:00",
    @StringRes val timeError: Int? = null,
    val workoutType : String = "",
    @StringRes val workoutTypeError: Int? = null,
)

fun TrainingsFormState.toRequest() = CreateWorkoutRequest(
    name = name,
    category = category,
    exercises = exercises.map { it.id!! }
)

fun ExerciseFormState.toRequest() = CreateExerciseRequest(
    title = title,
    description = description,
    videoUrl = videoUrl,
    series = series,
    repetitions = repetitions,
    time = time,
    workoutType = listOf(workoutType)
)

sealed class TrainingsFormEvent {
    data class OnNameChanged(val name: String) : TrainingsFormEvent()
    data class OnCategoryChanged(val category : String) : TrainingsFormEvent()
    data class OnExercisesChanged(val exercises: List<ExerciseState>) : TrainingsFormEvent()
    data object RemoveCurrentTraining : TrainingsFormEvent()
    data object OnSubmit : TrainingsFormEvent()
}

sealed class ExerciseFormEvent {
    data class OnTitleChanged(val title: String) : ExerciseFormEvent()
    data class OnDescriptionChanged(val description: String) : ExerciseFormEvent()
    data class OnVideoUrlChanged(val videoUrl: String) : ExerciseFormEvent()
    data class OnSeriesChanged(val series: String) : ExerciseFormEvent()
    data class OnRepetitionsChanged(val repetitions: String) : ExerciseFormEvent()
    data class OnTimeChanged(val time: String) : ExerciseFormEvent()
    data class RemoveCurrentExercise(val index: Int) : ExerciseFormEvent()
    data class OnCategoryChanged(val id: String, val category : String) : ExerciseFormEvent()
    data object OnSubmit : ExerciseFormEvent()
}