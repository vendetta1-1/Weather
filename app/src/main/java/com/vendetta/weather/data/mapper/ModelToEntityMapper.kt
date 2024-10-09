package com.vendetta.weather.data.mapper

import com.vendetta.weather.data.network.model.AstroModel
import com.vendetta.weather.data.network.model.ConditionModel
import com.vendetta.weather.data.network.model.CurrentModel
import com.vendetta.weather.data.network.model.DayModel
import com.vendetta.weather.data.network.model.ForecastDayModel
import com.vendetta.weather.data.network.model.ForecastModel
import com.vendetta.weather.data.network.model.HourModel
import com.vendetta.weather.data.network.model.LocationModel
import com.vendetta.weather.data.network.model.WeatherModel
import com.vendetta.weather.domain.entity.AstroEntity
import com.vendetta.weather.domain.entity.ConditionEntity
import com.vendetta.weather.domain.entity.CurrentEntity
import com.vendetta.weather.domain.entity.DayEntity
import com.vendetta.weather.domain.entity.ForecastDayEntity
import com.vendetta.weather.domain.entity.ForecastEntity
import com.vendetta.weather.domain.entity.HourEntity
import com.vendetta.weather.domain.entity.LocationEntity
import com.vendetta.weather.domain.entity.WeatherEntity

class ModelToEntityMapper {


    fun weatherModelToEntity(weatherModel: WeatherModel) = WeatherEntity(
        location = weatherModel.location.toEntity(),
        current = weatherModel.current.toEntity(),
        forecast = weatherModel.forecast.toEntity()
    )


    private fun AstroModel.toEntity() = AstroEntity(
        sunrise = this.sunrise,
        sunset = this.sunset
    )


    private fun ConditionModel.toEntity() = ConditionEntity(
        text = this.text
    )

    private fun CurrentModel.toEntity() =
        CurrentEntity(
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
            feelslikeC = this.feelslikeC,
            visKm = this.visKm,
            uv = this.uv
        )

    private fun DayModel.toEntity() =
        DayEntity(
            maxtempC = this.maxtempC,
            mintempC = this.mintempC,
            dailyWillItRain = this.dailyWillItRain,
            dailyChanceOfRain = this.dailyChanceOfRain,
            condition = this.condition.toEntity(),
            uv = this.uv
        )

    private fun ForecastDayModel.toEntity() =
        ForecastDayEntity(
            date = this.date,
            dateEpoch = this.dateEpoch,
            dayEntity = this.day.toEntity(),
            astro = this.astro.toEntity(),
            hour = this.hour.map { it.toEntity() }

        )

    private fun HourModel.toEntity() =
        HourEntity(
            timeEpoch = this.timeEpoch,
            time = this.time,
            tempC = this.tempC,
            condition = this.condition.toEntity(),
            chanceOfRain = this.chanceOfRain
        )

    private fun ForecastModel.toEntity() =
        ForecastEntity(
            forecastDay = this.forecastday.map { it.toEntity() }
        )

    private fun LocationModel.toEntity() =
        LocationEntity(
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