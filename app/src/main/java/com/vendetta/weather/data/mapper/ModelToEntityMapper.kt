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


    fun weatherModelToWeatherEntity(weatherModel: WeatherModel) =
        WeatherEntity(
            location = locationModelToLocationEntity(weatherModel.location),
            current = currentModelToCurrentEntity(weatherModel.current),
            forecast =  forecastModelToEntity(weatherModel.forecast)
        )


    private fun astroModelToAstroEntity(astroModel: AstroModel) =
        AstroEntity(
            sunrise = astroModel.sunrise,
            sunset = astroModel.sunset
        )


    private fun conditionModelToConditionEntity(conditionModel: ConditionModel) =
        ConditionEntity(
            text = conditionModel.text
        )

    private fun currentModelToCurrentEntity(currentModel: CurrentModel) =
        CurrentEntity(
            lastUpdatedEpoch = currentModel.lastUpdatedEpoch,
            lastUpdated = currentModel.lastUpdated,
            tempC = currentModel.tempC,
            condition = conditionModelToConditionEntity(currentModel.condition),
            windKph = currentModel.windKph,
            windDegree = currentModel.windDegree,
            windDir = currentModel.windDir,
            pressureMb = currentModel.pressureMb,
            pressureIn = currentModel.pressureIn,
            humidity = currentModel.humidity,
            cloud = currentModel.cloud,
            feelslikeC = currentModel.feelslikeC,
            visKm = currentModel.visKm,
            uv = currentModel.uv
        )

    private fun dayModelToDayEntity(dayModel: DayModel) =
        DayEntity(
            maxtempC = dayModel.maxtempC,
            mintempC = dayModel.mintempC,
            dailyWillItRain = dayModel.dailyWillItRain,
            dailyChanceOfRain = dayModel.dailyChanceOfRain,
            condition = conditionModelToConditionEntity(dayModel.condition),
            uv = dayModel.uv
        )

    private fun forecastDayModelToForecastDayEntity(forecastDayModel: ForecastDayModel) =
        ForecastDayEntity(
            date = forecastDayModel.date,
            dateEpoch = forecastDayModel.dateEpoch,
            dayEntity = dayModelToDayEntity(forecastDayModel.day),
            astro = astroModelToAstroEntity(forecastDayModel.astro),
            hour = forecastDayModel.hour.map { hourModelToHourEntity(it) }

        )

    private fun hourModelToHourEntity(hourModel: HourModel) =
        HourEntity(
            timeEpoch = hourModel.timeEpoch,
            time = hourModel.time,
            tempC = hourModel.tempC,
            condition = conditionModelToConditionEntity(hourModel.condition),
            chanceOfRain = hourModel.chanceOfRain
        )

    private fun forecastModelToEntity(forecastModel: ForecastModel) =
        ForecastEntity(
            forecastDay = forecastModel.forecastday.map { forecastDayModelToForecastDayEntity(it) }
        )

    private fun locationModelToLocationEntity(locationModel: LocationModel) =
        LocationEntity(
            name = locationModel.name,
            region = locationModel.region,
            country = locationModel.country,
            lat = locationModel.lat,
            lon = locationModel.lon,
            tzId = locationModel.tzId,
            localtimeEpoch = locationModel.localtimeEpoch,
            localtime = locationModel.localtime
        )


}