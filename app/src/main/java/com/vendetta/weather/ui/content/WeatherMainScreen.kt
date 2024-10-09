package com.vendetta.weather.ui.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val weatherEntity = viewModel.weatherEntity.observeAsState()
}