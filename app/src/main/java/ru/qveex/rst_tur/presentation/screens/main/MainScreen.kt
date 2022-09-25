package ru.qveex.rst_tur.presentation.screens.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.navigation.SetupNavGraph
import ru.qveex.rst_tur.presentation.components.BottomNav
import ru.qveex.rst_tur.presentation.components.TopBarMain

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {

    var title by remember { mutableStateOf("") }
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect{ backStackEntry ->
            title = backStackEntry.destination.label.toString()
        }
    }

    Scaffold(
        topBar = {
             TopBarMain(
                 isDarkTheme = sharedViewModel.isDarkThemeState.value,
                 title = sharedViewModel.title.value,
                 onClickNavIcon = {
                     if (navController.currentDestination?.route != Screen.Home.route)
                         navController.popBackStack()
                 }
             ) {
                 sharedViewModel.changeThemeState()
             }
        },
        bottomBar = { BottomNav(navController = navController) },
        content = {
            Box(modifier = Modifier.padding(it)) {
                SetupNavGraph(navController = navController, sharedViewModel = sharedViewModel)
            }
        }
    )
}