package com.vendetta.weather.data.mapper

import com.vendetta.weather.data.network.dto.AstroDto
import com.vendetta.weather.data.network.dto.ConditionDto
import com.vendetta.weather.data.network.dto.CurrentDto
import com.vendetta.weather.data.network.dto.DayDto
import com.vendetta.weather.data.network.dto.ForecastDayDto
import com.vendetta.weather.data.network.dto.LocationDto
import com.vendetta.weather.data.network.dto.WeatherDto
import com.vendetta.weather.domain.entity.weather.AstroEntity
import com.vendetta.weather.domain.entity.weather.ConditionEntity
import com.vendetta.weather.domain.entity.weather.CurrentEntity
import com.vendetta.weather.domain.entity.weather.DayEntity
import com.vendetta.weather.domain.entity.weather.ForecastDayEntity
import com.vendetta.weather.domain.entity.weather.LocationEntity
import com.vendetta.weather.domain.entity.weather.WeatherEntity

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
