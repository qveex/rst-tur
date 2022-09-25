package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.lists.*
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    sharedViewModel.changeScreenTitle(Screen.Home.title)
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { FoodList(foods = homeViewModel.foods) }
        item { RoomList(rooms = homeViewModel.rooms) }
        item { FunList(funs = homeViewModel.funs) }
        item { BlogList(blogs = homeViewModel.blogs, navController = navController ) }
        item { KidList(kids = homeViewModel.kids) }
        item { TourList(tours = homeViewModel.tours) }
    }
}