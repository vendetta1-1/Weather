package com.vendetta.weather.presentation.search

import com.vendetta.weather.domain.entity.weather.WeatherEntity

sealed class SearchScreenState {

    data object Initial : SearchScreenState()

    data object Loading : SearchScreenState()

    data class Success(
        val currentWeatherEntity: WeatherEntity,
        val tomorrowWeatherEntity: WeatherEntity,
        val dayAfterTomorrowWeatherEntity: WeatherEntity,
    ) : SearchScreenState()
}