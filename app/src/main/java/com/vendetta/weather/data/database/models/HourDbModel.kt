package com.vendetta.weather.data.database.models

import androidx.room.Embedded


data class HourDbModel(
    val timeEpoch: Int,
    val time: String,
    val tempC: Double,
    @Embedded(prefix = "condition/")
    val condition: ConditionDbModel,
    val chanceOfRain: Int
)