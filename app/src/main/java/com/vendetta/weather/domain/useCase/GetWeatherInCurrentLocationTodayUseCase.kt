package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.data.WeatherRepositoryImpl

class GetWeatherInCurrentLocationTodayUseCase(
    private val repository: WeatherRepositoryImpl
) {


    suspend fun invoke(location: Location) {
        repository.getWeatherInCurrentLocationToday(location)
    }

}