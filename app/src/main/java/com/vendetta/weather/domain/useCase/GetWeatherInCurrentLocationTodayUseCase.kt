package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.entity.WeatherEntity

class GetWeatherInCurrentLocationTodayUseCase(
    private val repository: WeatherRepositoryImpl
) {


    suspend operator fun invoke(location: Location) : WeatherEntity {
       return repository.getWeatherInCurrentLocationToday(location)
    }

}