package com.vendetta.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntity(
    val location: LocationEntity,
    val current: CurrentEntity,
    val forecastDay: ForecastDayEntity
)