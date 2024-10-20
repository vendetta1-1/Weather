package com.vendetta.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vendetta.weather.R

val Typography = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_condensed
            )
        ),
        fontWeight = FontWeight(400)
    ),
    titleMedium = TextStyle(
        fontSize = 18.sp,
        lineHeight = 21.sp,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_condensed
            )
        ),
        fontWeight = FontWeight(400)
    ),
    titleSmall = TextStyle(
        fontSize = 10.sp,
        lineHeight = 11.sp,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_condensed
            )
        ),
        fontWeight = FontWeight(400)
    ),
    labelLarge = TextStyle(
        fontSize = 96.sp,
        lineHeight = 1.sp,
        letterSpacing = 0.sp,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_condensed
            )
        ),
        fontWeight = FontWeight(400)
    ),
    labelMedium = TextStyle(
        fontSize = 36.sp,
        lineHeight = 1.sp,
        letterSpacing = 0.sp,
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_condensed
            )
        ),
        fontWeight = FontWeight(400)
    )
)