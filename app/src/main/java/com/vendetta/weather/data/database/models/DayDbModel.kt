package com.vendetta.weather.data.database.models

import androidx.room.Embedded


data class DayDbModel(
    val maxTempC: Double,
    val minTempC: Double,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    @Embedded(prefix = "condition/")
    val condition: ConditionDbModel,
    val uv: Double
)