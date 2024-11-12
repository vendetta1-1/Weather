package com.vendetta.weather.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WeatherDto(

    @SerializedName("location")
    @Expose
    val location: LocationDto,
    @SerializedName("current")
    @Expose
    val current: CurrentDto,
    @SerializedName("forecast")
    @Expose
    val forecast: ForecastDto

)