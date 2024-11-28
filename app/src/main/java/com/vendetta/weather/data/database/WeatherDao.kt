package com.vendetta.weather.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vendetta.weather.data.database.models.WeatherDBModel

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getWeatherInCities(): List<WeatherDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeather(weatherDBModel: WeatherDBModel)

    @Query("DELETE FROM weather WHERE `location/name`=:city")
    suspend fun deleteWeather(city: String)

//    @Query("SELECT * FROM weather WHERE location=:location LIMIT 1")
    //  fun getWeatherInCity(location: LocationDbModel) : WeatherDBModel
}