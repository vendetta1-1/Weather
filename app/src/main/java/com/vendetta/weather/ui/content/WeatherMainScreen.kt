package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun WeatherScreen(
    viewModel: MainViewModel = viewModel(),
    isCurrentLocation: Boolean
) {
    val weatherEntity = viewModel.weatherEntity.observeAsState()

    if (weatherEntity.value == null) {
        LoadingIndicator()
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
                    .padding(it)
            ) {

            }
        }
    }
}



