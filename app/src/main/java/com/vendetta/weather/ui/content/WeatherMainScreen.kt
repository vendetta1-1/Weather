package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun WeatherScreen(
    viewModel: MainViewModel = viewModel(),
    isCurrentLocation: Boolean
) {
    val weatherEntity = viewModel.weatherEntity.observeAsState()

    if (weatherEntity.value == null) {
        StartScreen()
    } else {
        val weatherEntityValue = weatherEntity.value!!
        Scaffold(
            topBar = {
                WeatherTopAppBar(
                    city = weatherEntityValue.location.name,
                    isCurrentLocation
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding() + 50.dp)

            ) {
                with(viewModel) {
                    DateHeader(
                        dayOfWeekResource = getDayOfWeek(),
                        monthResource = getMonth(),
                        dayOfMonth = getDayOfMonth(),
                        year = getYear()
                    )
                }
                TempStatistics(
                    currentTempC = weatherEntityValue.current.tempC,
                    minTempC = weatherEntityValue.forecast.forecastDay[0].dayEntity.mintempC,
                    maxTempC = weatherEntityValue.forecast.forecastDay[0].dayEntity.maxtempC
                )


            }
        }
    }
}



