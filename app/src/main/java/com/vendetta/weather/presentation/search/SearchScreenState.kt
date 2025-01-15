package com.vendetta.weather.presentation.search

import com.vendetta.weather.domain.entity.WeatherEntity

sealed class SearchScreenState {

    data object Initial : SearchScreenState()

    data class Loading(
        val currentWeatherEntity: WeatherEntity,
        val tomorrowWeatherEntity: WeatherEntity,
        val dayAfterTomorrowWeatherEntity: WeatherEntity,
    ) : SearchScreenState()
}