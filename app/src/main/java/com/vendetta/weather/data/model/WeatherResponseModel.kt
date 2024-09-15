package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WeatherResponseModel(

    @SerializedName("location")
    @Expose
    val location: Location?,
    @SerializedName("current")
    @Expose
    val current: Current?,
    @SerializedName("forecast")
    @Expose
    val forecast: Forecast?

)