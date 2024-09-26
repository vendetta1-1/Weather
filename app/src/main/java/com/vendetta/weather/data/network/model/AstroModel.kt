package com.vendetta.weather.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AstroModel(

    @SerializedName("sunrise")
    @Expose
    val sunrise: String,
    @SerializedName("sunset")
    @Expose
    val sunset: String

)