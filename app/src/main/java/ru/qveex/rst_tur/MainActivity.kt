package ru.qveex.rst_tur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.qveex.rst_tur.presentation.screens.main.MainScreen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.ui.theme.RstturTheme

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sharedViewModel: SharedViewModel = hiltViewModel()
            RstturTheme(darkTheme = sharedViewModel.isDarkThemeState) {
                val navController = rememberAnimatedNavController()
                MainScreen(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}