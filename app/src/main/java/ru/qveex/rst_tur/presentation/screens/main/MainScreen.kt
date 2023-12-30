package ru.qveex.rst_tur.presentation.screens.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.navigation.SetupNavGraph
import ru.qveex.rst_tur.presentation.components.BottomNav
import ru.qveex.rst_tur.presentation.components.TopBarMain
import ru.qveex.rst_tur.utils.Constants

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    
    var title by remember { mutableStateOf("") }
    val popBackStack: () -> Unit = { navController.popBackStack() }
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    var showTopBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val context = LocalContext.current
    
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            title = when (backStackEntry.destination.route) {
                context.getString(Screen.Home.route) -> context.getString(Screen.Home.title)
                context.getString(Screen.Blog.route) -> context.getString(Screen.Blog.title)
                context.getString(Screen.Booking.route) -> context.getString(Screen.Booking.title)
                context.getString(Screen.Chats.route) -> context.getString(Screen.Chats.title)
                context.getString(Screen.Map.route) -> context.getString(Screen.Map.title)
                context.getString(Screen.Profile.route) -> context.getString(Screen.Profile.title)
                else -> ""
            }
        }
    }
    
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        context.getString(Screen.Splash.route) -> false
        context.getString(Screen.Blog.route) -> false
        else -> true
    }
    showTopBar = when (navBackStackEntry?.destination?.route) {
        context.getString(Screen.Splash.route) -> false
        context.getString(Screen.Blog.route) -> false
        else -> true
    }
    
    Scaffold(
        topBar = {
            if (showTopBar) TopBarMain(
                isDarkTheme = sharedViewModel.isDarkThemeState,
                title = sharedViewModel.title,
                onClickNavIcon =
                if (navController.currentDestination?.route != context.getString(Screen.Home.route)) popBackStack
                else Constants.EMPTY_LAMBDA
            ) {
                sharedViewModel.changeThemeState()
            }
        },
        bottomBar = { if (showBottomBar) BottomNav(navController = navController) },
        content = {
            Box(modifier = Modifier.padding(it)) {
                SetupNavGraph(navController = navController, sharedViewModel = sharedViewModel)
            }
        }
    )
}