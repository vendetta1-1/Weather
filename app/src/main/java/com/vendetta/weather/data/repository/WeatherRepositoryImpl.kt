package com.vendetta.weather.data.repository

import android.location.Location
import com.vendetta.weather.data.mapper.ModelToEntityMapper
import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository


class WeatherRepositoryImpl : WeatherRepository {

    private val apiService = ApiFactory.apiService

    private val mapper = ModelToEntityMapper()

    override suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherToday(
                formatLocation(location)
            )
        )
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherTomorrow(
                formatLocation(location)
            )
        )
    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherDayAfterTomorrow(
                formatLocation(location)
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserToday(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherToday(
                formatLocation(location)
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherTomorrow(
                formatLocation(location)
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToEntity(
            apiService.loadWeatherDayAfterTomorrow(
                formatLocation(location)
            )
        )
    }

    private fun formatLocation(location: Location): String {
        return "${location.latitude},${location.longitude}"
    }
}