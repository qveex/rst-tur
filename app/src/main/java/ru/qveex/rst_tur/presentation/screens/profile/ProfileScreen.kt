package ru.qveex.rst_tur.presentation.screens.profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.CircleButton
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun ProfileScreen(
    sharedViewModel: SharedViewModel,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { sharedViewModel.setSharedImage(it) }

    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(Screen.Profile.title) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircleButton(
            text = stringResource(R.string.click),
            onClicked = {
                photoPicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
            gradient = Brush.linearGradient(
                listOf(
                    Color(0xffc31432),
                    Color(0xff240b36),
                )
            ),
            textColor = Color.White,
            image = Icons.Outlined.Search
        )
    }
}