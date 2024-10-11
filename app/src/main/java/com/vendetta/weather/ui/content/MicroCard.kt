package com.vendetta.weather.ui.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R
import com.vendetta.weather.ui.theme.WeatherTheme

@Composable
fun MicroCard(
    modifier: Modifier = Modifier,
    value: String,
    imageId: Int,
    titleId: Int
) {
    Card(
        modifier = modifier.padding(4.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 18.dp, bottom = 18.dp, start = 11.dp)
                    .clip(RoundedCornerShape(50))
                    .size(30.dp)
                    .background(Color.White),
                contentScale = ContentScale.None,
                painter = painterResource(imageId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(titleId),
                    color = Color.Black,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = value,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}


@Composable
@Preview
fun TwoMicroCardInRowPreview() {
    WeatherTheme(
        darkTheme = false
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            MicroCard(
                value = "12 kph",
                imageId = R.drawable.wind,
                titleId = R.string.wind_speed,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
            MicroCard(
                value = "24%",
                imageId = R.drawable.rainy,
                titleId = R.string.rain_chance,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
