package com.vendetta.weather.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R

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

private fun getConditionImage(code: Int): Int {
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