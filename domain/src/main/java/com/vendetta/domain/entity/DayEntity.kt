package com.vendetta.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class DayEntity(
    val maxTempC: Double,
    val minTempC: Double,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val condition: ConditionEntity,
    val uv: Double
)