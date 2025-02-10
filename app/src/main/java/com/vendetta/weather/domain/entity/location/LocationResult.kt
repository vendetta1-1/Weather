package com.vendetta.weather.domain.entity.location

import android.location.Location

sealed class LocationResult {
    data class Success(val location: Location) : LocationResult()
    data class Error(val errorCode: Int) : LocationResult()

    companion object {
        const val NOT_PERMISSION_ERROR_CODE = 1
        const val GPS_IS_OFF_ERROR_CODE = 2
        const val UNKNOWN_ERROR_CODE = 3
    }
}