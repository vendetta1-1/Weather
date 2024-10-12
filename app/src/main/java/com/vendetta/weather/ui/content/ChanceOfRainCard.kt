package com.vendetta.weather.ui.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R

@Composable
fun ChanceOfRainCard(times: List<String>, chances: List<Int>) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 11.dp, start = 11.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(30.dp)
                    .background(Color.White),
                contentScale = ContentScale.None,
                painter = painterResource(R.drawable.rainy),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.chance_of_rain),
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    bottom = 16.dp,
                    end = 11.dp
                )
        ) {
            RainChanceUnit(times[5].takeLast(5), chances[5])
            RainChanceUnit(times[11].takeLast(5), chances[11])
            RainChanceUnit(times[17].takeLast(5), chances[17])
            RainChanceUnit(times[23].takeLast(5), chances[23])

        }
    }
}


@Composable
fun RainChanceUnit(time: String, chance: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = time, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.weight(1f))
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(12.dp),
            progress = { chance.toFloat() / 100 },
            color = MaterialTheme.colorScheme.onSurface,
            trackColor = MaterialTheme.colorScheme.surface,
            gapSize = (-4).dp,
            drawStopIndicator = {},

            )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$chance%", style = MaterialTheme.typography.titleMedium)
    }
}
