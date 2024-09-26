package com.vendetta.weather.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ForecastModel(

    @SerializedName("forecastday")
    @Expose
    val forecastday: List<ForecastDayModel>

)