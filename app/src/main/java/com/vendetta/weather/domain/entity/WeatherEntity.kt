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
    val location: LocationEntity = LocationEntity(
        name = "",
        region = "",
        country = "",
        lat = 0.0,
        lon = 0.0,
        tzId = "",
        localtimeEpoch = 0,
        localtime = ""
    ),
    val current: CurrentEntity = CurrentEntity(
        lastUpdatedEpoch = 0,
        lastUpdated = "",
        tempC = 0.0,
        condition = ConditionEntity(text = ""),
        windKph = 0.0,
        windDegree = 0.0,
        windDir = "",
        pressureMb = 0.0,
        pressureIn = 0.0,
        humidity = 0,
        cloud = 0,
        feelsLikeC = 0.0,
        visKm = 0.0,
        uv = 0.0
    ),
    val forecastDay: ForecastDayEntity = ForecastDayEntity(
        date = "",
        dateEpoch = 0,
        dayEntity = DayEntity(
            maxTempC = 0.0,
            minTempC = 0.0,
            dailyChanceOfRain = 0,
            condition = ConditionEntity(
                text = "",
                code = 0
            ),
            uv = 0.0,
            dailyWillItRain = 0
        ),
        astro = AstroEntity(
            sunset = "",
            sunrise = ""
        )
    )
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