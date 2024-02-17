package com.ufape.shaypado.data.model

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("userType")
    val userType: String,
    @SerializedName("weigth") //TODO  wrong name
    val weight: String?,
    @SerializedName("height")
    val height: String?,
//    @SerializedName("objective")
//    val objective : String?,
    @SerializedName("any_disease")
    val anyDisease : String
)

data class UserResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("userType")
    val userType: String,
    @SerializedName("weight")
    val weight: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("objective")
    val objective : String?,
    @SerializedName("any_disease")
    val anyDisease : String
)

