package ru.qveex.rst_tur.presentation.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.utils.Constants

@Composable
fun TopBarMain(
    isDarkTheme: Boolean,
    title: String,
    onClickNavIcon: () -> Unit,
    onThemeSwitch: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            if (onClickNavIcon != Constants.EMPTY_LAMBDA) {
                IconButton(
                    onClick = { onClickNavIcon() }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.back_icon_content_description)
                    )
                }
            }
        },
        title = {
            Text(
                modifier = Modifier.animateContentSize(),
                text = title,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        actions = {
            SwitchThemeButton(isDarkTheme = isDarkTheme) { onThemeSwitch() }
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
fun SwitchThemeButton(
    isDarkTheme: Boolean,
    onThemeSwitch: () -> Unit
) {

    IconToggleButton(
        checked = isDarkTheme,
        onCheckedChange = { onThemeSwitch() },
        modifier = Modifier.size(Icons.Outlined.DarkMode.defaultHeight * 2)
    ) {
        FloatingActionButton(
            onClick = { onThemeSwitch() },
            elevation = elevation(0.dp)
        ) {
            Crossfade(
                targetState = isDarkTheme,
            ) {
                Icon(
                    imageVector = if (it) Icons.Outlined.DarkMode else Icons.Outlined.LightMode,
                    contentDescription = stringResource(R.string.theme_icon_content_description),
                    tint = MaterialTheme.colors.onBackground,
                )
            }
        }
    }
}