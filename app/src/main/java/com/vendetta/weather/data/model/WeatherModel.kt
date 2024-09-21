package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WeatherModel(

    @SerializedName("location")
    @Expose
    val location: LocationModel,
    @SerializedName("current")
    @Expose
    val current: CurrentModel,
    @SerializedName("forecast")
    @Expose
    val forecast: ForecastModel

)