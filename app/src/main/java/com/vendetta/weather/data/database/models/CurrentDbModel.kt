package com.vendetta.weather.data.database.models

import androidx.room.Embedded

data class CurrentDbModel(
    val lastUpdatedEpoch: Int,
    val lastUpdated: String,
    val tempC: Double,
    @Embedded(prefix = "condition_")
    val condition: ConditionDbModel,
    val windKph: Double,
    val windDegree: Double,
    val windDir: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeC: Double,
    val visKm: Int,
    val uv: Double
)