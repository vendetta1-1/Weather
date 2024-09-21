package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ConditionModel(

    @SerializedName("text")
    @Expose
    val text: String

)