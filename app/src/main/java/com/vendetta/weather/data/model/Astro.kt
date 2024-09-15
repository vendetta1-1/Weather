package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Astro(

    @SerializedName("sunrise")
    @Expose
    val sunrise: String?,
    @SerializedName("sunset")
    @Expose
    val sunset: String?

)