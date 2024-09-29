package com.vendetta.weather.domain.repository

import android.location.Location
import com.vendetta.weather.domain.entity.WeatherEntity

interface WeatherRepository {

    suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity

    suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity

    suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserToday(location: Location): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location): WeatherEntity

    suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(location: Location): WeatherEntity

}