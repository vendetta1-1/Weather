package com.example.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    @Expose
    val forecastday: List<ForecastDayDto>
)
