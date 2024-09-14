package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind(

    @SerializedName("speed")
    @Expose
    private val speed: Double,
    @SerializedName("deg")
    @Expose
    private val deg: Int,
    @SerializedName("gust")
    @Expose
    private val gust: Double
)