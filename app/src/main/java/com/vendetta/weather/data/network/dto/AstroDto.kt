package com.vendetta.weather.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AstroDto(

    @SerializedName("sunrise")
    @Expose
    val sunrise: String,
    @SerializedName("sunset")
    @Expose
    val sunset: String

)