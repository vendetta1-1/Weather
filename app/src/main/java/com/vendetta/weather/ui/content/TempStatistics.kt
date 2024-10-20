package com.vendetta.weather.ui.content

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R

@Composable
fun TempStatistics(
    currentTempC: Double,
    minTempC: Double,
    maxTempC: Double
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 4.dp),
        verticalArrangement = Arrangement.Center
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
                        append("°C")
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
        Spacer(modifier = Modifier.width(25.dp))
        ArrowWithText(
            resId = R.drawable.arrow_up,
            value = maxTempC
        )
    }
}

@Composable
fun ArrowWithText(
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