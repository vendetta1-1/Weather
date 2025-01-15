package com.vendetta.weather.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vendetta.weather.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onButtonClickListener: (String) -> Unit,
    onBackButtonBackListener: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 70.dp),
                title = {
                    Text(
                        text = stringResource(R.string.find_city),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackButtonBackListener() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) {
        var city by remember { mutableStateOf("Paris") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //настроить цвета поля для ввода
            TextField(
                value = city,
                onValueChange = { city = it },
                label = { Text(text = stringResource(R.string.city)) },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(
                        top = it.calculateTopPadding() + 20.dp,
                    )
            )

            Button(
                onClick = { onButtonClickListener(city) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    disabledContainerColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(
                    text = stringResource(R.string.find),
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
