package com.vendetta.weather.domain.entity

data class DayEntity(
    val maxtempC: Double,
    val mintempC: Double,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val condition: ConditionEntity,
    val uv: Double

)