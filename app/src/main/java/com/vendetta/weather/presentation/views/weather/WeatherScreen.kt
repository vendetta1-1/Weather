package com.vendetta.weather.presentation.views.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.presentation.views.loading.LoadingViewModel

@Composable
fun WeatherScreen(
    weatherEntity: WeatherEntity,
    onSearchButtonClickListener: () -> Unit
) {
    Scaffold(
        topBar = {
            WeatherTopAppBar(
                city = weatherEntity.location.name,
                onSearchButtonClickListener = onSearchButtonClickListener
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding() + 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            with(LoadingViewModel) {
                DateHeader(
                    dayOfWeekResource = getDayOfWeek(),
                    monthResource = getMonth(),
                    dayOfMonth = getDayOfMonth(),
                    year = getYear()
                )
            }
            TempStatistics(
                currentTempC = weatherEntity.current.tempC,
                minTempC = weatherEntity.forecastDay.dayEntity.minTempC,
                maxTempC = weatherEntity.forecastDay.dayEntity.maxTempC
            )
            Spacer(
                modifier = Modifier
                    .height(64.dp)
            )
            ConditionHeader(
                text = weatherEntity.current.condition.text,
                code = weatherEntity.current.condition.code
            )
            Spacer(
                modifier = Modifier
                    .height(60.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MicroStatistic(
                    imageResId = R.drawable.pressure,
                    value = weatherEntity.current.pressureMb.toString()
                )
                MicroStatistic(
                    imageResId = R.drawable.humidity,
                    value = weatherEntity.current.humidity.toString()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WeatherTopAppBar(
    city: String,
    isCurrentLocation: Boolean = true,
    onSearchButtonClickListener: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(top = 70.dp),
        title = {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = city,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                if (isCurrentLocation) {
                    Spacer(
                        modifier = Modifier
                            .height(6.dp)
                    )
                    Text(
                        text = stringResource(R.string.current_location),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { onSearchButtonClickListener() }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

@Composable
private fun TempStatistics(
    currentTempC: Double,
    minTempC: Double,
    maxTempC: Double
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            letterSpacing = MaterialTheme.typography.labelLarge.letterSpacing,
                            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                            fontWeight = MaterialTheme.typography.labelLarge.fontWeight
                        )
                    ) {
                        append(currentTempC.toString())
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = MaterialTheme.typography.labelMedium.fontSize,
                            letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing,
                            fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
                            fontWeight = MaterialTheme.typography.labelMedium.fontWeight
                        )
                    ) {
                        append(stringResource(R.string.gradus_celsius))
                    }

                },
                color = MaterialTheme.colorScheme.onBackground
            )


        }
    }
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ArrowWithText(
            resId = R.drawable.arrow_down,
            value = minTempC
        )
        Spacer(modifier = Modifier.width(32.dp))
        ArrowWithText(
            resId = R.drawable.arrow_up,
            value = maxTempC
        )
    }
}

@Composable
private fun ArrowWithText(
    resId: Int,
    value: Double
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(resId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun MicroStatistic(
    imageResId: Int,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(imageResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.secondary
        )
        Spacer(
            modifier = Modifier
                .width(5.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun DateHeader(
    dayOfWeekResource: Int,
    monthResource: Int,
    dayOfMonth: String,
    year: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${stringResource(dayOfWeekResource)},$dayOfMonth ${stringResource(monthResource)} $year",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )

    }
}

@Composable
fun ConditionHeader(
    text: String,
    code: Int
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(getConditionImage(code)),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

fun getConditionImage(code: Int): Int {
    return when (code) {
        1000 -> R.drawable.sunny
        1003 -> R.drawable.partly_cloudy
        1006 -> R.drawable.cloudy
        1009 -> R.drawable.overcast
        1030, 1135, 1147 -> R.drawable.mist
        1063, 1072, 1150, 1153 -> R.drawable.rain
        1066 -> R.drawable.snow
        1069, 1168, 1171 -> R.drawable.sleety
        1087 -> R.drawable.thunder
        1114, 1117 -> R.drawable.blizzard

        else -> R.drawable.sunny
    }
}



