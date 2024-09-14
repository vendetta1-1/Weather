package com.vendetta.weather.presentation

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.data.WeatherRepositoryImpl
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val location = Location("Rostov")


    private val repository = WeatherRepositoryImpl()

    private val useCase = GetWeatherInCurrentLocationTodayUseCase(repository)

    fun loadWeather() {
        viewModelScope.launch {
            location.longitude = 39.7139
            location.latitude = 47.2364
            useCase.invoke(location)
        }
    }


}