package com.vendetta.weather.presentation

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.di.DaggerRepositoryImplComponent
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val component = DaggerRepositoryImplComponent.create()
    private val repository = component.getRepositoryImpl()

    private val location = Location("Rostov")

    private val useCase = GetWeatherInCurrentLocationTodayUseCase(repository)


    fun loadWeather() {
        viewModelScope.launch {
            location.longitude = 39.7139
            location.latitude = 47.2364
           Log.i("Weather-Response",useCase.invoke(location).toString())
        }
    }


}