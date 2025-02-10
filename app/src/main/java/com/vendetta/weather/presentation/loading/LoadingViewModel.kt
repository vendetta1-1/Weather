package com.vendetta.weather.presentation.loading

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTomorrowUseCase
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


    fun loadWeather(location: Location) {
        viewModelScope.launch {
            _screenState.emit(
                LoadingScreenState.Success(
                    currentWeatherEntity = getWeatherInCurrentLocationTodayUseCase(location),
                    tomorrowWeatherEntity = getWeatherInCurrentLocationTomorrowUseCase(location),
                    dayAfterTomorrowWeatherEntity = getWeatherInCurrentLocationDayAfterTomorrowUseCase(
                        location
                    )
                )
            )
        }
    }
}
