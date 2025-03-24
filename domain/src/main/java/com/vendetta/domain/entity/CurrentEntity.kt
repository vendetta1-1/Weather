package com.vendetta.domain.entity


import kotlinx.serialization.Serializable

@Serializable
data class CurrentEntity(
    val lastUpdatedEpoch: Int,
    val lastUpdated: String,
    val tempC: Double,
    val condition: ConditionEntity,
    val windKph: Double,
    val windDegree: Double,
    val windDir: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeC: Double,
    val visKm: Double,
    val uv: Double
)