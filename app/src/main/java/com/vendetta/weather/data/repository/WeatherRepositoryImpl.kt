package com.vendetta.weather.data.repository

import android.location.Location
import com.vendetta.weather.data.mapper.ModelToEntityMapper
import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor() : WeatherRepository {


    private val apiService = ApiFactory.apiService

    private val mapper = ModelToEntityMapper()

    override suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherToday(
                "${location.latitude},${location.longitude}"
            )
        )

    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherTomorrow(
                "${location.latitude},${location.longitude}"
            )
        )
    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherDayAfterTomorrow(
                "${location.latitude},${location.longitude}"
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserToday(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherToday(
                "${location.latitude},${location.longitude}"
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherTomorrow(
                "${location.latitude},${location.longitude}"
            )
        )
    }

    override suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(location: Location): WeatherEntity {
        return mapper.weatherModelToWeatherEntity(
            apiService.loadWeatherDayAfterTomorrow(
                "${location.latitude},${location.longitude}"
            )
        )
    }

}