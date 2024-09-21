package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.data.WeatherRepositoryImpl
import com.vendetta.weather.domain.entity.WeatherEntity

class GetWeatherInCurrentLocationTodayUseCase(
    private val repository: WeatherRepositoryImpl
) {


    suspend fun invoke(location: Location) : WeatherEntity {
       return repository.getWeatherInCurrentLocationToday(location)
    }

}