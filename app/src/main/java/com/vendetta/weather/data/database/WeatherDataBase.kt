package com.vendetta.weather.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vendetta.weather.data.database.models.WeatherDBModel

@Database(entities = [WeatherDBModel::class], version = 1, exportSchema = false)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {

        private const val DB_NAME = "FavouriteDatabase"
        private var INSTANCE: WeatherDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): WeatherDataBase {
            INSTANCE?.let { return it }

            synchronized(LOCK) {
                INSTANCE?.let { return it }

                val database = Room.databaseBuilder(
                    context = application,
                    klass = WeatherDataBase::class.java,
                    name = DB_NAME
                ).build()

                INSTANCE = database
                return database
            }
        }
    }
}