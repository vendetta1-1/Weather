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
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTomorrowUseCase
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getWeatherInCurrentLocationTodayUseCase: GetWeatherInCurrentLocationTodayUseCase,
    val getWeatherInCurrentLocationTomorrowUseCase: GetWeatherInCurrentLocationTomorrowUseCase,
    val getWeatherInCurrentLocationDayAfterTomorrowUseCase: GetWeatherInCurrentLocationDayAfterTomorrowUseCase
) : ViewModel() {

    private val _currentWeatherEntity = MutableLiveData<WeatherEntity>()
    val currentWeatherEntity: LiveData<WeatherEntity>
        get() = _currentWeatherEntity

    private val _tomorrowWeatherEntity = MutableLiveData<WeatherEntity>()
    val tomorrowWeatherEntity: LiveData<WeatherEntity>
        get() = _tomorrowWeatherEntity

    private val _dayAfterTomorrowWeatherEntity = MutableLiveData<WeatherEntity>()
    val dayAfterTomorrowWeatherEntity: LiveData<WeatherEntity>
        get() = _dayAfterTomorrowWeatherEntity

    private fun loadCurrentWeather(location: Location) {
        viewModelScope.launch {
            _currentWeatherEntity.value = getWeatherInCurrentLocationTodayUseCase(location)
            Log.i(
                TAG, _currentWeatherEntity.value.toString()
            )
        }
    }

    private fun loadTomorrowWeather(location: Location) {
        viewModelScope.launch {
            _tomorrowWeatherEntity.value = getWeatherInCurrentLocationTomorrowUseCase(location)
            Log.i(
                TAG, _tomorrowWeatherEntity.value.toString()
            )
        }
    }

    private fun loadDayAfterTomorrowWeather(location: Location) {
        viewModelScope.launch {
            _dayAfterTomorrowWeatherEntity.value =
                getWeatherInCurrentLocationDayAfterTomorrowUseCase(location)
            Log.i(TAG, _dayAfterTomorrowWeatherEntity.value.toString())
        }
    }

    val permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
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
            fusedLocationProviderClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                object : CancellationToken() {
                    override fun onCanceledRequested(p0: OnTokenCanceledListener) =
                        CancellationTokenSource().token

                    override fun isCancellationRequested() = false
                }).addOnSuccessListener {
                if (it != null) {
                    loadCurrentWeather(it)
                    loadTomorrowWeather(it)
                    loadDayAfterTomorrowWeather(it)
                } else {
                    getWeather(activity, fusedLocationProviderClient)
                }
            }
        } else {
            showDialogueWindow(activity)
            getWeather(activity, fusedLocationProviderClient)
        }
    }

    companion object {
        private const val TAG = "Weather-Response"
        const val RC_LOCATION = 101

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
    }
}