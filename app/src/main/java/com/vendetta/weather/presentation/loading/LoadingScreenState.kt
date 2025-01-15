package com.vendetta.weather.presentation.loading

import com.vendetta.weather.domain.entity.WeatherEntity

sealed class LoadingScreenState {

    data object Initial : LoadingScreenState()

    class Success(
        val currentWeatherEntity: WeatherEntity,
        val tomorrowWeatherEntity: WeatherEntity,
        val dayAfterTomorrowWeatherEntity: WeatherEntity
    ) : LoadingScreenState()
}