package com.vendetta.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vendetta.weather.R

val Typography = Typography(
    //title on MicroCard
    titleMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily(
            Font(
                R.font.product_sans
            )
        ),
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight(400)
    ),
    // value on MicroCard
    titleSmall = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.product_sans)),
        fontWeight = FontWeight(400),
        letterSpacing = 0.15.sp,
    )
)