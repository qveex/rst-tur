package ru.qveex.rst_tur.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import ru.qveex.rst_tur.presentation.screens.blog.BlogScreen
import ru.qveex.rst_tur.presentation.screens.booking.BookingScreen
import ru.qveex.rst_tur.presentation.screens.chats.ChatsScreen
import ru.qveex.rst_tur.presentation.screens.home.HomeScreen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.presentation.screens.map.MapScreen
import ru.qveex.rst_tur.presentation.screens.profile.ProfileScreen
import ru.qveex.rst_tur.presentation.screens.splash.SplashScreen
import ru.qveex.rst_tur.utils.Constants.BLOG_ARGUMENT_KEY
import ru.qveex.rst_tur.utils.Constants.INITIAL_OFFSET_X
import ru.qveex.rst_tur.utils.Constants.SCREEN_TRANSIT_DURATION_MILLIS
import ru.qveex.rst_tur.utils.Constants.TARGET_OFFSET_X

@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.Splash.route,
            enterTransition = { fadeIn(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS * 2)) },
            exitTransition = { fadeOut(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS * 2)) },
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screen.Home.route,
            enterTransition = { if (navController.currentDestination!!.route!! != Screen.Splash.route) { fadeIn(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS)) } else { enterAnim() } } ,
            exitTransition = { exitAnim() },
        ) {
            HomeScreen(sharedViewModel = sharedViewModel, navController = navController)
        }
        composable(
            route = Screen.Map.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() },
        ) {
            MapScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Booking.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() }
        ) {
            BookingScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Chats.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() }
        ) {
            ChatsScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Profile.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() }
        ) {
            ProfileScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Blog.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() },
            arguments = listOf(navArgument(BLOG_ARGUMENT_KEY) { type = NavType.IntType })
        ) {
            BlogScreen(sharedViewModel = sharedViewModel, blogId = it.arguments!!.getInt(BLOG_ARGUMENT_KEY))
        }
    }
}

fun enterAnim() = slideInHorizontally(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS), initialOffsetX = { INITIAL_OFFSET_X })
fun exitAnim() = slideOutHorizontally(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS), targetOffsetX = { TARGET_OFFSET_X })