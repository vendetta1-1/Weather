package com.vendetta.weather.ui.content

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val currentWeather =
        viewModel.currentWeatherEntity.observeAsState(WeatherEntity.defaultValue)
    val tomorrowWeather =
        viewModel.tomorrowWeatherEntity.observeAsState(WeatherEntity.defaultValue)
    val dayAfterTomorrowWeather =
        viewModel.dayAfterTomorrowWeatherEntity.observeAsState(WeatherEntity.defaultValue)
    if (
        currentWeather.value == WeatherEntity.defaultValue ||
        tomorrowWeather.value == WeatherEntity.defaultValue ||
        dayAfterTomorrowWeather.value == WeatherEntity.defaultValue
    ) {
        StartScreen()
    } else {
        Scaffold(
            topBar = {
                WeatherTopAppBar(
                    city = currentWeather.value.location.name,
                    isCurrentLocation = true
                )
            }
        ) { padding ->
            WeatherScreen(
                weatherEntity = currentWeather,
                topPadding = padding.calculateTopPadding()
            )
        }
    }
}