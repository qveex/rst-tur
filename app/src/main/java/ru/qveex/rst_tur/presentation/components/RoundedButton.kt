package ru.qveex.rst_tur.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.ui.theme.DarkButtonBackgroung
import ru.qveex.rst_tur.ui.theme.DarkButtonContent
import ru.qveex.rst_tur.ui.theme.LightButtonBackgroung
import ru.qveex.rst_tur.ui.theme.LightButtonContent


@Composable
fun RoundedButton (
    isDarkTheme: Boolean,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isDarkTheme) DarkButtonBackgroung else LightButtonBackgroung,
            contentColor = if (isDarkTheme) DarkButtonContent else LightButtonContent
        ),
        border = BorderStroke(1.dp, if (isDarkTheme) DarkButtonContent else LightButtonContent),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}