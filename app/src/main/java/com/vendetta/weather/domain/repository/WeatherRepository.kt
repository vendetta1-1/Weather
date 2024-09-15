package com.vendetta.weather.domain.repository

import android.location.Location

interface WeatherRepository {

    suspend fun getWeatherInCurrentLocationToday(location: Location)

    suspend fun getWeatherInCurrentLocationTomorrow(location: Location)

    suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location)

    suspend fun getWeatherInCityPeakedByUserToday(location: Location)

    suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location)

    suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(location: Location)

}