package ru.qveex.rst_tur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import ru.qveex.rst_tur.presentation.screens.main.MainScreen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.ui.theme.RstturTheme

class MainActivity : ComponentActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RstturTheme(darkTheme = sharedViewModel.isDarkThemeState.value) {
                val navController = rememberNavController()
                MainScreen(
                    sharedViewModel = sharedViewModel,
                    navController = navController
                )
            }
        }
    }
}