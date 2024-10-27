package com.vendetta.weather.presentation

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.vendetta.weather.R
import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import kotlinx.coroutines.launch
import java.util.Calendar


class MainViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl()

    private val _weatherEntity = MutableLiveData<WeatherEntity>()
    val weatherEntity: LiveData<WeatherEntity>
        get() = _weatherEntity

    private val getWeatherInCurrentLocationTodayUseCase =
        GetWeatherInCurrentLocationTodayUseCase(repository)

    private fun loadWeather(location: Location) {
        viewModelScope.launch {
            _weatherEntity.value = getWeatherInCurrentLocationTodayUseCase(location)
            Log.i(
                "Weather-Response", getWeatherInCurrentLocationTodayUseCase(location).toString()
            )
        }
    }

    val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private fun checkLocationPermission(context: Context): Boolean {
        return (ContextCompat.checkSelfPermission(
            context,
            permissions[0]
        ) == PackageManager.PERMISSION_GRANTED)
    }

    private fun showDialogueWindow(activity: Activity) {
        ActivityCompat.requestPermissions(activity, permissions, RC_LOCATION)
    }

    fun getWeather(
        activity: Activity,
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        if (checkLocationPermission(activity)) {
            fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY,
                object : CancellationToken() {
                    override fun onCanceledRequested(p0: OnTokenCanceledListener) =
                        CancellationTokenSource().token

                    override fun isCancellationRequested() = false
                }).addOnSuccessListener {
                if (it != null) {
                    loadWeather(it)
                } else {
                    showDialogueWindow(activity)
                }
            }
        } else {
            showDialogueWindow(activity)
        }
    }

    fun getDayOfWeek(): Int {
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        return when (dayOfWeek) {
            Calendar.MONDAY -> R.string.monday
            Calendar.TUESDAY -> R.string.tuesday
            Calendar.WEDNESDAY -> R.string.wednesday
            Calendar.THURSDAY -> R.string.thursday
            Calendar.FRIDAY -> R.string.friday
            Calendar.SATURDAY -> R.string.saturday
            else -> R.string.sunday
        }
    }

    fun getDayOfMonth() = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()

    fun getMonth(): Int {
        val month = Calendar.getInstance().get(Calendar.MONTH)
        return when (month) {
            Calendar.DECEMBER -> R.string.december
            Calendar.JANUARY -> R.string.january
            Calendar.FEBRUARY -> R.string.february
            Calendar.MARCH -> R.string.march
            Calendar.APRIL -> R.string.april
            Calendar.MAY -> R.string.may
            Calendar.JUNE -> R.string.june
            Calendar.JULY -> R.string.july
            Calendar.AUGUST -> R.string.august
            Calendar.SEPTEMBER -> R.string.september
            Calendar.OCTOBER -> R.string.october
            else -> R.string.november
        }
    }

    fun getYear() = Calendar.getInstance().get(Calendar.YEAR).toString()

    companion object {
        const val RC_LOCATION = 101
    }

}