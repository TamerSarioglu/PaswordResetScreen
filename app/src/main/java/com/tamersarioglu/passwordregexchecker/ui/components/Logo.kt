package com.tamersarioglu.passwordregexchecker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tamersarioglu.passwordregexchecker.R

@Composable
fun StarbucksLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.starbucks_logo),
        contentDescription = "Starbucks Logo",
        modifier = modifier.size(48.dp)
    )
} 