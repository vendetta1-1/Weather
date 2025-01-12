package com.vendetta.weather.presentation.views.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserTomorrowUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getWeatherInCityPeakedByUserTodayUseCase: GetWeatherInCityPeakedByUserTodayUseCase,
    private val getWeatherInCityPeakedByUserTomorrowUseCase: GetWeatherInCityPeakedByUserTomorrowUseCase,
    private val getWeatherInCityPeakedByUserDayAfterTomorrowUseCase: GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
) : ViewModel() {
    private val _currentWeather = MutableLiveData<WeatherEntity>()
    val currentWeather: LiveData<WeatherEntity>
        get() = _currentWeather

    private val _tomorrowWeather = MutableLiveData<WeatherEntity>()
    val tomorrowWeather: LiveData<WeatherEntity>
        get() = _tomorrowWeather

    private val _dayAfterTomorrowWeather = MutableLiveData<WeatherEntity>()
    val dayAfterTomorrowWeather: LiveData<WeatherEntity>
        get() = _dayAfterTomorrowWeather

    fun loadCurrentWeather(city: String) {
        viewModelScope.launch {
            _currentWeather.value = getWeatherInCityPeakedByUserTodayUseCase(city)
        }
    }

    fun loadTomorrowWeather(city: String) {
        viewModelScope.launch {
            _tomorrowWeather.value = getWeatherInCityPeakedByUserTomorrowUseCase(city)
        }
    }

    fun loadDayAfterTomorrowWeather(city: String) {
        viewModelScope.launch {
            _dayAfterTomorrowWeather.value =
                getWeatherInCityPeakedByUserDayAfterTomorrowUseCase(city)
        }
    }
}