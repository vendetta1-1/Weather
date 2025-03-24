package com.vendetta.domain.repository

import com.vendetta.domain.entity.WeatherEntity


interface WeatherRepository {

    suspend fun getWeatherInCurrentLocationToday(latitude: Double, longitude: Double): WeatherEntity

    suspend fun getWeatherInCurrentLocationTomorrow(
        latitude: Double, longitude: Double
    ): WeatherEntity

    suspend fun getWeatherInCurrentLocationDayAfterTomorrow(
        latitude: Double, longitude: Double
    ): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserToday(city: String): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserTomorrow(city: String): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(city: String): WeatherEntity
}