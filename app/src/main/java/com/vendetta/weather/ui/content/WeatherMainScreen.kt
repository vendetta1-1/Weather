package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.vendetta.weather.R
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun WeatherScreen(
    weatherEntity: LiveData<WeatherEntity>,
    isCurrentLocation: Boolean
) {
    if (weatherEntity.observeAsState().value == null) {
        StartScreen()
    } else {
        val weatherEntityValue = weatherEntity.observeAsState().value!!
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
                with(MainViewModel) {
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
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MicroStatistic(
                        imageResId = R.drawable.pressure,
                        value = weatherEntityValue.current.pressureMb.toString()
                    )
                    MicroStatistic(
                        imageResId = R.drawable.humidity,
                        value = weatherEntityValue.current.humidity.toString()
                    )
                }
            }
        }
    }
}



