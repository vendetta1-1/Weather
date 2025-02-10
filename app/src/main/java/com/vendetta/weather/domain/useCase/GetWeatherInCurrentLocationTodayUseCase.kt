package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.domain.entity.weather.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInCurrentLocationTodayUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(location: Location): WeatherEntity {
        return weatherRepository.getWeatherInCurrentLocationToday(location)
    }
}