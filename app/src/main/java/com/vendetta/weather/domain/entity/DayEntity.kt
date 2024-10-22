package com.vendetta.weather.domain.entity

data class DayEntity(
    val maxTempC: Double,
    val minTempC: Double,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val condition: ConditionEntity,
    val uv: Double

)