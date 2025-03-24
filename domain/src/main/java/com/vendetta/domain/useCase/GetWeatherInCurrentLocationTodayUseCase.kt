package com.vendetta.domain.useCase

import com.vendetta.domain.entity.WeatherEntity
import com.vendetta.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInCurrentLocationTodayUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double): WeatherEntity {
        return repository.getWeatherInCurrentLocationToday(latitude, longitude)
    }
}