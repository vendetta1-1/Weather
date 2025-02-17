package com.vendetta.weather.domain.entity

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherEntity(
    val location: LocationEntity,
    val current: CurrentEntity,
    val forecastDay: ForecastDayEntity
) : Parcelable {
    companion object {

        val NavigationType: NavType<WeatherEntity> = object : NavType<WeatherEntity>(
            isNullableAllowed = false
        ) {
            @RequiresApi(Build.VERSION_CODES.TIRAMISU)
            override fun get(bundle: Bundle, key: String): WeatherEntity? {
                return bundle.getParcelable(key, WeatherEntity::class.java)
            }

            override fun parseValue(value: String): WeatherEntity {
                return Gson().fromJson(value, WeatherEntity::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: WeatherEntity) {
                bundle.putParcelable(key, value)
            }

        }
    }
}