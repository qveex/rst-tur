package ru.qveex.rst_tur.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.ui.theme.ButtonBackground


@Composable
fun RoundedButton (
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ButtonBackground.copy(alpha = 0.08f),
            contentColor = ButtonBackground
        ),
        elevation = elevation(0.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, ButtonBackground),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}