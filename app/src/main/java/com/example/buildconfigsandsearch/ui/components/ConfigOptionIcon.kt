package com.example.buildconfigsandsearch.ui.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buildconfigsandsearch.R

@Composable
fun ConfigOptionIcon(
    size: Dp = 20.dp,
    painter: Painter,
    tint: Color? = null
) {
    Row {
        Icon(
            painter = painter,
            contentDescription = "Ícone de Configuração",
            modifier = Modifier.size(size),
            tint = tint ?: Color.White
        )
    }

}

@Preview
@Composable
private fun ConfigOptionIcon() {
    MaterialTheme {
        ConfigOptionIcon(painter = painterResource(R.drawable.ic_bluetooth))
    }
}

