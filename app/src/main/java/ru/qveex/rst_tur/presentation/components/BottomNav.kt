package ru.qveex.rst_tur.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.qveex.rst_tur.navigation.Screen

@Composable
fun BottomNav(navController: NavHostController) {
    
    val screens = listOf(
        Screen.Home,
        Screen.Map,
        Screen.Booking,
        Screen.Chats,
        Screen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    BottomNavigation {
        screens.forEach {
            AddItem(screen = it, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val context = LocalContext.current
    
    BottomNavigationItem(
        label = {
            Text(text = stringResource(id = screen.title), style = MaterialTheme.typography.caption)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = stringResource(id = screen.title)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == stringResource(id = screen.route)
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            if (navController.currentDestination!!.route == context.getString(screen.route)) return@BottomNavigationItem
            navController.navigate(context.getString(screen.route)) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}