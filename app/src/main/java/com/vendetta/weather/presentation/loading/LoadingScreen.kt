package com.vendetta.weather.presentation.loading

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Granularity
import com.google.android.gms.location.Priority
import com.vendetta.weather.R
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.factory.ViewModelFactory

@Composable
fun LoadingScreen(
    navToWeather: (WeatherEntity, Boolean) -> Unit,
    viewModelFactory: ViewModelFactory,
    locationClient: FusedLocationProviderClient
) {
    val viewModel: LoadingViewModel = viewModel(factory = viewModelFactory)
    val screenState = viewModel.screenState.collectAsState(LoadingScreenState.Initial)
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
            if (it) {
                loadWeather(
                    context = context,
                    viewModel = viewModel,
                    locationClient = locationClient
                )
            } else {
                Toast.makeText(
                    context,
                    R.string.toast_need_permission,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    )

    when (val currentState = screenState.value) {
        is LoadingScreenState.Initial -> {
            LoadingScreenContent()
            SideEffect {
                launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
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

private fun loadWeather(
    context: Context,
    viewModel: LoadingViewModel,
    locationClient: FusedLocationProviderClient,
) {
    if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        val currentLocationRequest = CurrentLocationRequest.Builder()
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .setGranularity(Granularity.GRANULARITY_FINE)
            .setDurationMillis(2000)
        locationClient.getCurrentLocation(currentLocationRequest.build(), null)
            .addOnSuccessListener {
                if (it != null) {
                    viewModel.loadWeather(it)
                } else {
                    Toast.makeText(
                        context,
                        R.string.toast_necessary_turn_on_location,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}

