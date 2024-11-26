package com.vendetta.weather.domain.useCase

import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInCitiesFromDBUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(): List<WeatherEntity> {
        return repository.getWeatherInCitiesFromDB()
    }
}