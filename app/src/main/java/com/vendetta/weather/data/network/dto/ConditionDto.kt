package com.vendetta.weather.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ConditionDto(
    @SerializedName("text")
    @Expose
    val text: String,
    @SerializedName("code")
    @Expose
    val code: Int
)