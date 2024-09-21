package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ForecastDayModel(

    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("date_epoch")
    @Expose
    val dateEpoch: Int,
    @SerializedName("day")
    @Expose
    val day: DayModel,
    @SerializedName("astro")
    @Expose
    val astro: AstroModel,
    @SerializedName("hour")
    @Expose
    val hour: List<HourModel>

)