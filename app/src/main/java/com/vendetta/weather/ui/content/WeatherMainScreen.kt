package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.R
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val weatherEntity = viewModel.weatherEntity.observeAsState()

    Column {
        Text(
            text = weatherEntity.value?.location?.name.toString() + "," +
                    weatherEntity.value?.location?.country.toString()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MicroCard(
                modifier = Modifier.fillMaxWidth(0.5f),
                imageId = R.drawable.sunset,
                titleId = R.string.sunset,
                value = weatherEntity.value?.forecast?.forecastDay[0]?.astro?.sunset.toString()
            )
            MicroCard(
                modifier = Modifier.fillMaxWidth(),
                imageId = R.drawable.sunrise,
                titleId = R.string.sunrise,
                value = weatherEntity.value?.forecast?.forecastDay[0]?.astro?.sunrise.toString()
            )
        }
        ChanceOfRainCard(
            times = weatherEntity.value?.forecast?.forecastDay[0]?.hour?.map { it.time }
                ?: listOf(),
            chances = weatherEntity.value?.forecast?.forecastDay[0]?.hour?.map { it.chanceOfRain }
                ?: listOf()
        )
    }

}