package com.ufape.shaypado.data.model

import com.google.gson.annotations.SerializedName
import com.ufape.shaypado.ui.model.CategoryState
import com.ufape.shaypado.ui.screens.trainer.updateWorkout.CategoriesState

data class CategoryResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("category")
    val category: String
)

fun CategoryResponse.toUiModel() = CategoryState(
    id = id,
    category = category
)