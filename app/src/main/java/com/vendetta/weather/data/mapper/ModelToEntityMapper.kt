package com.vendetta.weather.data.mapper

import com.vendetta.weather.data.network.dto.AstroDto
import com.vendetta.weather.data.network.dto.ConditionDto
import com.vendetta.weather.data.network.dto.CurrentDto
import com.vendetta.weather.data.network.dto.DayDto
import com.vendetta.weather.data.network.dto.ForecastDayDto
import com.vendetta.weather.data.network.dto.ForecastDto
import com.vendetta.weather.data.network.dto.HourDto
import com.vendetta.weather.data.network.dto.LocationDto
import com.vendetta.weather.data.network.dto.WeatherDto
import com.vendetta.weather.domain.entity.AstroEntity
import com.vendetta.weather.domain.entity.ConditionEntity
import com.vendetta.weather.domain.entity.CurrentEntity
import com.vendetta.weather.domain.entity.DayEntity
import com.vendetta.weather.domain.entity.ForecastDayEntity
import com.vendetta.weather.domain.entity.ForecastEntity
import com.vendetta.weather.domain.entity.HourEntity
import com.vendetta.weather.domain.entity.LocationEntity
import com.vendetta.weather.domain.entity.WeatherEntity
import javax.inject.Inject

class ModelToEntityMapper @Inject constructor() {


    fun weatherModelToEntity(weatherDto: WeatherDto) = WeatherEntity(
        location = weatherDto.location.toEntity(),
        current = weatherDto.current.toEntity(),
        forecast = weatherDto.forecast.toEntity()
    )

    private fun AstroDto.toEntity() = AstroEntity(
        sunrise = this.sunrise, sunset = this.sunset
    )

    private fun ConditionDto.toEntity() = ConditionEntity(
        text = this.text, code = this.code
    )

    private fun CurrentDto.toEntity() = CurrentEntity(
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

    private fun DayDto.toEntity() = DayEntity(
        maxTempC = this.maxTempC,
        minTempC = this.minTempC,
        dailyWillItRain = this.dailyWillItRain,
        dailyChanceOfRain = this.dailyChanceOfRain,
        condition = this.condition.toEntity(),
        uv = this.uv
    )

    private fun ForecastDayDto.toEntity() = ForecastDayEntity(date = this.date,
        dateEpoch = this.dateEpoch,
        dayEntity = this.day.toEntity(),
        astro = this.astro.toEntity(),
        hour = this.hour.map { it.toEntity() }

    )

    private fun HourDto.toEntity() = HourEntity(
        timeEpoch = this.timeEpoch,
        time = this.time,
        tempC = this.tempC,
        condition = this.condition.toEntity(),
        chanceOfRain = this.chanceOfRain
    )

    private fun ForecastDto.toEntity() =
        ForecastEntity(forecastDay = this.forecastday.map { it.toEntity() })

    private fun LocationDto.toEntity() = LocationEntity(
        name = this.name,
        region = this.region,
        country = this.country,
        lat = this.lat,
        lon = this.lon,
        tzId = this.tzId,
        localtimeEpoch = this.localtimeEpoch,
        localtime = this.localtime
    )
}