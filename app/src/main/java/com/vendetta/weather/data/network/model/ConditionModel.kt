package com.vendetta.weather.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ConditionModel(
    @SerializedName("text")
    @Expose
    val text: String,
    @SerializedName("code")
    @Expose
    val code: Int? = null,
)