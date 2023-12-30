package ru.qveex.rst_tur.navigation

import androidx.annotation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import ru.qveex.rst_tur.*
import ru.qveex.rst_tur.utils.Constants.BLOG_ARGUMENT_KEY

sealed class Screen(
    @StringRes val route: Int,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object Home: Screen(
        route = R.string.home_route,
        title = R.string.home,
        icon = Icons.Outlined.Home
    )

    object Map: Screen(
        route = R.string.map_route,
        title = R.string.map,
        icon = Icons.Outlined.Map
    )

    object Booking: Screen(
        route = R.string.booking_route,
        title = R.string.booking,
        icon = Icons.Outlined.LocalMall
    )

    object Chats: Screen(
        route = R.string.chats_route,
        title = R.string.chats,
        icon = Icons.Outlined.Forum
    )

    object Profile: Screen(
        route = R.string.profile_route,
        title = R.string.profile,
        icon = Icons.Outlined.Person
    )

    object Blog: Screen(
        route = R.string.blog_route_argument_key,
        title = R.string.blog,
        icon = Icons.Outlined.Close
    ) {
        fun passId(blogId: Int) = "blog/$blogId"
    }

    object Splash: Screen(
        route = R.string.splash,
        title = R.string.splash,
        icon = Icons.Outlined.Animation
    )
}
