package ru.qveex.rst_tur.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import ru.qveex.rst_tur.utils.Constants.BLOG_ARGUMENT_KEY

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: Screen(
        route = "home",
        title = "Главная",
        icon = Icons.Outlined.Home
    )

    object Map: Screen(
        route = "map",
        title = "Карта",
        icon = Icons.Outlined.Map
    )

    object Booking: Screen(
        route = "booking",
        title = "Бронь",
        icon = Icons.Outlined.LocalMall
    )

    object Chats: Screen(
        route = "chats",
        title = "Чаты",
        icon = Icons.Outlined.Forum
    )

    object Profile: Screen(
        route = "profile",
        title = "Профиль",
        icon = Icons.Outlined.Person
    )

    object Blog: Screen(
        route = "blog/{$BLOG_ARGUMENT_KEY}",
        title = "Блог",
        icon = Icons.Outlined.Close
    ) {
        fun passId(blogId: Int) = "blog/$blogId"
    }

    object Splash: Screen(
        route = "splash",
        title = "Splash",
        icon = Icons.Outlined.Animation
    )
}
