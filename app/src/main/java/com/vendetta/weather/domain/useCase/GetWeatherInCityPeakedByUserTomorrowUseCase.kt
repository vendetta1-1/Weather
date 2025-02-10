package com.vendetta.weather.domain.useCase

import com.vendetta.weather.domain.entity.weather.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInCityPeakedByUserTomorrowUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(city: String): WeatherEntity {
        return repository.getWeatherInCityPeakedByUserTomorrow(city)
    }
}