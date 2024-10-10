package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.R
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val weatherEntity = viewModel.weatherEntity.observeAsState()

    Column {
        Row {
            MicroCard(
                imageId = R.drawable.sunset,
                titleId = R.string.sunset,
                value = weatherEntity.value?.forecast?.forecastDay[0]?.astro?.sunset.toString()
            )
            MicroCard(
                imageId = R.drawable.sunrise,
                titleId = R.string.sunrise,
                value = weatherEntity.value?.forecast?.forecastDay[0]?.astro?.sunrise.toString()
            )
        }
        ChanceOfRainCard(
            times = listOf(weatherEntity.value?.forecast?.forecastDay[0]?.hour[0]?.time.toString()),
            chances = weatherEntity.value?.forecast?.forecastDay[0]?.hour?.map { it.chanceOfRain }
                ?: listOf()
        )
    }

}