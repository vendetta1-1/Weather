package com.vendetta.weather.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserTomorrowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getWeatherInCityPeakedByUserTodayUseCase: GetWeatherInCityPeakedByUserTodayUseCase,
    private val getWeatherInCityPeakedByUserTomorrowUseCase: GetWeatherInCityPeakedByUserTomorrowUseCase,
    private val getWeatherInCityPeakedByUserDayAfterTomorrowUseCase: GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
) : ViewModel() {

    private val _screenState = MutableLiveData<SearchScreenState>()
    val screenState: LiveData<SearchScreenState> = _screenState

    fun loadWeather(city: String) {
        _screenState.value = SearchScreenState.Loading
        viewModelScope.launch {
            _screenState.value = async(Dispatchers.IO) {
                SearchScreenState.Success(
                    currentWeatherEntity = getWeatherInCityPeakedByUserTodayUseCase(city),
                    tomorrowWeatherEntity = getWeatherInCityPeakedByUserTomorrowUseCase(city),
                    dayAfterTomorrowWeatherEntity =
                    getWeatherInCityPeakedByUserDayAfterTomorrowUseCase(city)
                )
            }.await()
        }
    }

}