package com.vendetta.weather.presentation.loading

import android.Manifest
import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.R
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.factory.ViewModelFactory

@Composable
fun LoadingScreen(
    navToWeather: (WeatherEntity, Boolean) -> Unit,
    viewModelFactory: ViewModelFactory,
    activity: Activity
) {
    val viewModel: LoadingViewModel = viewModel(factory = viewModelFactory)
    val screenState = viewModel.screenState.observeAsState(LoadingScreenState.Initial)
    var isPermissionGranted by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isPermissionGranted = it }
    )

    SideEffect {
        if (!isPermissionGranted){
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        viewModel.getWeather(activity)

    }

    when (val currentState = screenState.value) {
        is LoadingScreenState.Initial -> {
            LoadingScreenContent()
        }

        is LoadingScreenState.Success -> {
            LoadingScreenContent()
            navToWeather(currentState.currentWeatherEntity, true)
        }
    }

}

@Composable
private fun LoadingScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.start_label),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}
