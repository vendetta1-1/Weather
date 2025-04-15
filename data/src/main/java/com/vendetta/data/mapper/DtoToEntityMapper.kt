package com.vendetta.data.mapper

import com.example.data.network.dto.*
import com.vendetta.domain.entity.*

fun WeatherDto.toEntity() = WeatherEntity(
    location = this.location.toEntity(),
    current = this.current.toEntity(),
    forecastDay = this.forecast.forecastday[0].toEntity()
)

fun ForecastDayDto.toEntity() = ForecastDayEntity(
    date = this.date,
    dateEpoch = this.dateEpoch,
    dayEntity = this.day.toEntity(),
    astro = this.astro.toEntity()
)

fun AstroDto.toEntity() = AstroEntity(
    sunrise = this.sunrise,
    sunset = this.sunset
)

fun ConditionDto.toEntity() = ConditionEntity(
    text = this.text,
    code = this.code
)

fun CurrentDto.toEntity() = CurrentEntity(
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
    feelsLikeC = this.feelslikeC,
    visKm = this.visKm,
    uv = this.uv
)

fun DayDto.toEntity() = DayEntity(
    maxTempC = this.maxTempC,
    minTempC = this.minTempC,
    dailyWillItRain = this.dailyWillItRain,
    dailyChanceOfRain = this.dailyChanceOfRain,
    condition = this.condition.toEntity(),
    uv = this.uv
)


fun LocationDto.toEntity() = LocationEntity(
    name = this.name,
    region = this.region,
    country = this.country,
    lat = this.lat,
    lon = this.lon,
    tzId = this.tzId,
    localtimeEpoch = this.localtimeEpoch,
    localtime = this.localtime
)
