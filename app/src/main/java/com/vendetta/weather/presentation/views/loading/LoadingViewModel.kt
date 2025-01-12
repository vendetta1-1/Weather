package com.vendetta.weather.presentation.views.loading

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Location
import android.widget.Toast
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
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTomorrowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val getWeatherInCurrentLocationTodayUseCase: GetWeatherInCurrentLocationTodayUseCase,
    private val getWeatherInCurrentLocationTomorrowUseCase: GetWeatherInCurrentLocationTomorrowUseCase,
    private val getWeatherInCurrentLocationDayAfterTomorrowUseCase: GetWeatherInCurrentLocationDayAfterTomorrowUseCase
) : ViewModel() {

    private val _screenState = MutableLiveData<LoadingScreenState>(LoadingScreenState.Initial)
    val screenState: LiveData<LoadingScreenState>
        get() = _screenState


    private fun loadWeather(location: Location) {
        viewModelScope.launch {
            _screenState.value = async(Dispatchers.IO) {
                LoadingScreenState.Success(
                    currentWeatherEntity = getWeatherInCurrentLocationTodayUseCase(location),
                    tomorrowWeatherEntity = getWeatherInCurrentLocationTomorrowUseCase(location),
                    dayAfterTomorrowWeatherEntity = getWeatherInCurrentLocationDayAfterTomorrowUseCase(
                        location
                    )
                )
            }.await()
        }

    }


    @SuppressLint("MissingPermission")
    fun getWeather(
        activity: Activity,
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY,
            object : CancellationToken() {
                override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken =
                    CancellationTokenSource().token

                override fun isCancellationRequested(): Boolean = false
            }).addOnSuccessListener {
            if (it != null) {
                loadWeather(it)
            } else {
                Toast.makeText(
                    activity, R.string.toast_necessary_turn_on_location, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    companion object {

        private val calendar = Calendar.getInstance()

        fun getDayOfWeek(): Int {
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
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

        fun getDayOfMonth() = calendar.get(Calendar.DAY_OF_MONTH).toString()

        fun getMonth(): Int {
            val month = calendar.get(Calendar.MONTH)
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

        fun getYear() = calendar.get(Calendar.YEAR).toString()
    }
}