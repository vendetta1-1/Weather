package com.vendetta.domain.entity

import kotlinx.serialization.Serializable


@Serializable
data class ForecastEntity(
    val forecastDay: List<ForecastDayEntity>
)