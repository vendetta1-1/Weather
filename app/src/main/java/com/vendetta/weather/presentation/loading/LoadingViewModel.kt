package com.vendetta.weather.presentation.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase
import com.vendetta.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import com.vendetta.domain.useCase.GetWeatherInCurrentLocationTomorrowUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val getWeatherInCurrentLocationTodayUseCase: GetWeatherInCurrentLocationTodayUseCase,
    private val getWeatherInCurrentLocationTomorrowUseCase: GetWeatherInCurrentLocationTomorrowUseCase,
    private val getWeatherInCurrentLocationDayAfterTomorrowUseCase: GetWeatherInCurrentLocationDayAfterTomorrowUseCase,
) : ViewModel() {

    private val _screenState: MutableStateFlow<LoadingScreenState> =
        MutableStateFlow(LoadingScreenState.Initial)

    val screenState = _screenState.asStateFlow()


    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _screenState.emit(
                LoadingScreenState.Success(
                    currentWeatherEntity = getWeatherInCurrentLocationTodayUseCase(
                        latitude,
                        longitude
                    ),
                    tomorrowWeatherEntity = getWeatherInCurrentLocationTomorrowUseCase(
                        latitude,
                        longitude
                    ),
                    dayAfterTomorrowWeatherEntity = getWeatherInCurrentLocationDayAfterTomorrowUseCase(
                        latitude, longitude
                    )
                )
            )
        }
    }
}
