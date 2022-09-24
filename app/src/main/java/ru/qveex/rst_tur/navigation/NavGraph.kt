package ru.qveex.rst_tur.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.qveex.rst_tur.presentation.screens.blog.BlogScreen
import ru.qveex.rst_tur.presentation.screens.booking.BookingScreen
import ru.qveex.rst_tur.presentation.screens.chats.ChatsScreen
import ru.qveex.rst_tur.presentation.screens.home.HomeScreen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.presentation.screens.map.MapScreen
import ru.qveex.rst_tur.presentation.screens.profile.ProfileScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(sharedViewModel)
        }
        composable(
            route = Screen.Map.route
        ) {
            MapScreen()
        }
        composable(
            route = Screen.Booking.route
        ) {
            BookingScreen()
        }
        composable(
            route = Screen.Chats.route
        ) {
            ChatsScreen()
        }
        composable(
            route = Screen.Profile.route
        ) {
            ProfileScreen(sharedViewModel)
        }
        composable(
            route = Screen.Blog.route
        ) {
            BlogScreen(sharedViewModel)
        }

    }
}