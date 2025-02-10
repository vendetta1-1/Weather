package com.vendetta.weather.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCityPeakedByUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getWeatherInCityPeakedByUserTodayUseCase: GetWeatherInCityPeakedByUserUseCase,
    private val getWeatherInCityPeakedByUserTomorrowUseCase: GetWeatherInCityPeakedByUserTomorrowUseCase,
    private val getWeatherInCityPeakedByUserDayAfterTomorrowUseCase: GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<SearchScreenState>(SearchScreenState.Initial)
    val screenState = _screenState.asStateFlow()

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _screenState.emit(SearchScreenState.Loading)
            _screenState.emit(
                SearchScreenState.Success(
                    currentWeatherEntity = getWeatherInCityPeakedByUserTodayUseCase(city),
                    tomorrowWeatherEntity = getWeatherInCityPeakedByUserTomorrowUseCase(city),
                    dayAfterTomorrowWeatherEntity = getWeatherInCityPeakedByUserDayAfterTomorrowUseCase(
                        city
                    )
                )
            )
        }
    }

}