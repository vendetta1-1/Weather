package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates(

    @SerializedName("lon")
    @Expose
    private val longitude: Double,
    @SerializedName("lat")
    @Expose
    private val latitude: Double

)
