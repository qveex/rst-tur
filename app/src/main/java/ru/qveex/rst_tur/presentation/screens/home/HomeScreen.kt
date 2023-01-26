package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.ShimmerList
import ru.qveex.rst_tur.presentation.components.UpButton
import ru.qveex.rst_tur.presentation.components.list
import ru.qveex.rst_tur.presentation.components.list_items.*
import ru.qveex.rst_tur.presentation.components.lists.FunList
import ru.qveex.rst_tur.presentation.components.single
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.presentation.screens.splash.HideUIVisibilityState
import ru.qveex.rst_tur.utils.AppStatus

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    HideUIVisibilityState(state = true)
    val systemUiController = rememberSystemUiController()
    val backgroundColor = MaterialTheme.colors.background

    val status = homeViewModel.status

    LaunchedEffect(Unit) {
        sharedViewModel.changeScreenTitle(Screen.Home.title)
        systemUiController.setSystemBarsColor(backgroundColor)
    }

    when(status) {
        is AppStatus.Idle -> {}
        is AppStatus.Loading -> { ShimmerList() }
        is AppStatus.Success -> {}
        is AppStatus.Error -> {}
    }

    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 14.dp, start = 14.dp, end = 14.dp),
        state = listState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {


        list(
            header = "Питание",
            items = homeViewModel.foods
        ) {
            FoodItem(food = it)
        }

        list(
            header = "Отели",
            items = homeViewModel.rooms,
            isSingleElementInRow = true
        ) { room ->
            RoomItem(room = room)
        }

        single { FunList(funs = homeViewModel.funs) }

        list(
            header = "Блог",
            items = homeViewModel.blogs,
            isSingleElementInRow = true
        ) { blog ->
            BlogItem(blog = blog) { navController.navigate(Screen.Blog.passId(blog.id)) }
        }

        list(
            header = "Для детей",
            items = homeViewModel.kids,
            isSingleElementInRow = true
        ) { kid ->
            KidItem(kid = kid)
        }

        list(
            header = "Туры",
            items = homeViewModel.tours
        ) { tour ->
            TourItem(tour = tour)
        }
    }
    UpButton(state = listState)

}