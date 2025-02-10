package com.vendetta.weather.domain.repository

import android.location.Location
import com.vendetta.weather.domain.entity.weather.WeatherEntity

interface WeatherRepository {

    suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity

    suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity

    suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserToday(city: String): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserTomorrow(city: String): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(city: String): WeatherEntity
}