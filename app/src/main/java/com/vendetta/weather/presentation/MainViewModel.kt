package com.vendetta.weather.presentation

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendetta.weather.R
import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.useCase.GetWeatherInCurrentLocationTodayUseCase
import kotlinx.coroutines.launch
import java.util.Calendar


class MainViewModel : ViewModel() {

    private val _weatherEntity = MutableLiveData<WeatherEntity>()
    val weatherEntity: LiveData<WeatherEntity>
        get() = _weatherEntity

    private val repository = WeatherRepositoryImpl()

    private val getWeatherInCurrentLocationTodayUseCase =
        GetWeatherInCurrentLocationTodayUseCase(repository)

    fun loadWeather(location: Location) {
        viewModelScope.launch {
            _weatherEntity.value = getWeatherInCurrentLocationTodayUseCase(location)
            Log.i(
                "Weather-Response",
                getWeatherInCurrentLocationTodayUseCase(location).toString()
            )
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

}