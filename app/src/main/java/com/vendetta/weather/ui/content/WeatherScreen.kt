package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun WeatherScreen(
    weatherEntity: State<WeatherEntity>,
    topPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topPadding + 50.dp),
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
            currentTempC = weatherEntity.value.current.tempC,
            minTempC = weatherEntity.value.forecast.forecastDay[0].dayEntity.minTempC,
            maxTempC = weatherEntity.value.forecast.forecastDay[0].dayEntity.maxTempC
        )
        Spacer(
            modifier = Modifier
                .height(64.dp)
        )
        ConditionHeader(
            text = weatherEntity.value.current.condition.text,
            code = weatherEntity.value.current.condition.code
        )
        Spacer(
            modifier = Modifier
                .height(60.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MicroStatistic(
                imageResId = R.drawable.pressure,
                value = weatherEntity.value.current.pressureMb.toString()
            )
            MicroStatistic(
                imageResId = R.drawable.humidity,
                value = weatherEntity.value.current.humidity.toString()
            )
        }
    }
}



