package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository

class GetWeatherInCityPeakedByUserTomorrowUseCase(
    private val repository: WeatherRepository
) {

    suspend fun invoke(location: Location) : WeatherEntity {
        return repository.getWeatherInCityPeakedByUserTomorrow(location)
    }

}