package com.vendetta.weather.domain.entity

data class WeatherEntity(
    val location: LocationEntity,
    val current: CurrentEntity,
    val forecastDay: ForecastDayEntity
) {
    companion object {
        val defaultValue= WeatherEntity(
            location = LocationEntity(
                name = "",
                region = "",
                country = "",
                lat = 0.0,
                lon = 0.0,
                tzId = "",
                localtimeEpoch = 0,
                localtime = ""
            ),
            current = CurrentEntity(
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
                visKm = 0,
                uv = 0.0
            ),
            forecastDay = ForecastDayEntity(
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
        )
    }
}