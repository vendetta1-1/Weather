package com.vendetta.weather.domain.entity


data class HourEntity(
    val timeEpoch: Int,
    val time: String,
    val tempC: Double,
    val condition: ConditionEntity,
    val chanceOfRain: Int
)