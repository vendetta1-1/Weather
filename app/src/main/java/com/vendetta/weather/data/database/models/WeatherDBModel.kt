package com.vendetta.weather.data.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherDBModel(
    @PrimaryKey
    @Embedded(prefix = "location/")
    val location: LocationDbModel,
    @Embedded(prefix = "current/")
    val current: CurrentDbModel,
    @Embedded(prefix = "forecast_day/")
    val forecastDay: ForecastDayDbModel
)