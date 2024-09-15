package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Hour(

    @SerializedName("time_epoch")
    @Expose
    val timeEpoch: Int,
    @SerializedName("time")
    @Expose
    val time: String,
    @SerializedName("temp_c")
    @Expose
    val tempC: Double,
    @SerializedName("condition")
    @Expose
    val condition: Condition,
    @SerializedName("chance_of_rain")
    @Expose
    val chanceOfRain: Int

)