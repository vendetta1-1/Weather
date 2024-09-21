package com.vendetta.weather.domain.entity


data class WeatherEntity(
    val location: LocationEntity,
    val current: CurrentEntity,
    val forecast: ForecastEntity
)