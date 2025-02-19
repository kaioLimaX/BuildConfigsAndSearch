package com.example.buildconfigsandsearch.ui.theme.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.buildconfigsandsearch.R

object IconsPainter {

    val BlueToothIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_bluetooth)
    val AboutIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_about)
    val BatteryIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_battery)
    val LocationIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_location)
    val ModeIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_modo_av)
    val ThemeIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_theme)
    val SoundIcon: Painter
        @Composable
        get() = painterResource(R.drawable.ic_sound)
}