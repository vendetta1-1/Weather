package com.vendetta.weather.presentation.weather

import com.vendetta.weather.R

sealed class DaysNavigationItem(
    val titleResId: Int
) {

    data object TodayNavigationItem : DaysNavigationItem(
        titleResId = R.string.today
    )

    data object TomorrowNavigationItem : DaysNavigationItem(
        titleResId = R.string.tomorrow
    )

    data object DayAfterTomorrowNavigationItem : DaysNavigationItem(
        titleResId = R.string.day_after_tomorrow
    )
}