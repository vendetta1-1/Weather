package com.vendetta.weather.data.database.models

import androidx.room.Embedded

data class ForecastDayDbModel(
    val date: String,
    val dateEpoch: Int,
    @Embedded(prefix = "day/")
    val day: DayDbModel,
    @Embedded(prefix = "astro/")
    val astro: AstroDbModel,
)