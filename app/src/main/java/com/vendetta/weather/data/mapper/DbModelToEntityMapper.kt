package com.vendetta.weather.data.mapper

import com.vendetta.weather.data.database.models.AstroDbModel
import com.vendetta.weather.data.database.models.ConditionDbModel
import com.vendetta.weather.data.database.models.CurrentDbModel
import com.vendetta.weather.data.database.models.DayDbModel
import com.vendetta.weather.data.database.models.ForecastDayDbModel
import com.vendetta.weather.data.database.models.LocationDbModel
import com.vendetta.weather.data.database.models.WeatherDBModel
import com.vendetta.weather.domain.entity.AstroEntity
import com.vendetta.weather.domain.entity.ConditionEntity
import com.vendetta.weather.domain.entity.CurrentEntity
import com.vendetta.weather.domain.entity.DayEntity
import com.vendetta.weather.domain.entity.ForecastDayEntity
import com.vendetta.weather.domain.entity.LocationEntity
import com.vendetta.weather.domain.entity.WeatherEntity


fun WeatherDBModel.toEntity() = WeatherEntity(
    location = this.location.toEntity(),
    current = this.current.toEntity(),
    forecastDay = this.forecastDay.toEntity()
)

private fun AstroDbModel.toEntity() = AstroEntity(
    sunrise = this.sunrise,
    sunset = this.sunset
)

fun DayDbModel.toEntity() = DayEntity(
    maxTempC = this.maxTempC,
    minTempC = this.minTempC,
    dailyWillItRain = this.dailyWillItRain,
    condition = this.condition.toEntity(),
    uv = this.uv,
    dailyChanceOfRain = this.dailyChanceOfRain
)

fun ForecastDayDbModel.toEntity() = ForecastDayEntity(
    date = this.date,
    dateEpoch = this.dateEpoch,
    dayEntity = this.day.toEntity(),
    astro = this.astro.toEntity()
)

fun LocationDbModel.toEntity() = LocationEntity(
    name = this.name,
    region = this.region,
    country = this.country,
    lat = this.lat,
    lon = this.lon,
    tzId = this.tzId,
    localtimeEpoch = this.localtimeEpoch,
    localtime = this.localtime
)

fun ConditionDbModel.toEntity() = ConditionEntity(
    text = this.text,
    code = this.code
)

fun CurrentDbModel.toEntity() = CurrentEntity(
    lastUpdatedEpoch = this.lastUpdatedEpoch,
    lastUpdated = this.lastUpdated,
    tempC = this.tempC,
    condition = this.condition.toEntity(),
    windKph = this.windKph,
    windDegree = this.windDegree,
    windDir = this.windDir,
    pressureMb = this.pressureMb,
    pressureIn = this.pressureIn,
    humidity = this.humidity,
    cloud = this.cloud,
    feelsLikeC = this.feelsLikeC,
    visKm = this.visKm,
    uv = this.uv
)
