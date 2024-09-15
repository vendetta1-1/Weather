package com.vendetta.weather.data.network

import androidx.compose.ui.text.intl.Locale
import com.vendetta.weather.data.model.WeatherResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface ApiService {

    @GET("forecast.json")
    suspend fun loadWeatherToday(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
        @Query("lang") language: String = Locale.current.language
    ) : WeatherResponseModel

    @GET("forecast.json")
    suspend fun loadWeatherTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
        @Query("lang") language: String = Locale.current.language,
        @Query("dt") day: String = LocalDate.now().plusDays(1).toString()
    ): WeatherResponseModel

    @GET("forecast.json")
    suspend fun loadWeatherDayAfterTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
        @Query("lang") language: String = Locale.current.language,
        @Query("dt") day: String = LocalDate.now().plusDays(2).toString()
    ): WeatherResponseModel
}