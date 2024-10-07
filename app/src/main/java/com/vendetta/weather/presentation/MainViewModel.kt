package com.vendetta.weather.presentation

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTomorrowUseCase
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _weatherEntity = MutableLiveData<WeatherEntity>()
    val weatherEntity: LiveData<WeatherEntity>
        get() = _weatherEntity

    private val repository = WeatherRepositoryImpl()

    private val location = Location("Rostov")

    private val getWeatherInCurrentLocationTodayUseCase =
        GetWeatherInCurrentLocationTodayUseCase(repository)


    fun loadWeather(location: Location) {
        viewModelScope.launch {
            Log.i(
                "Weather-Response",
                getWeatherInCurrentLocationTodayUseCase.invoke(location).toString()
            )
        }
    }


}