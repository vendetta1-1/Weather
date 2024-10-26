package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
                    .padding(top = it.calculateTopPadding() + 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally

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
                    minTempC = weatherEntityValue.forecast.forecastDay[0].dayEntity.minTempC,
                    maxTempC = weatherEntityValue.forecast.forecastDay[0].dayEntity.maxTempC
                )
                Spacer(
                    modifier = Modifier
                        .height(64.dp)
                )
                ConditionHeader(
                    text = weatherEntityValue.current.condition.text,
                    code = weatherEntityValue.current.condition.code
                )
            }
        }
    }
}



