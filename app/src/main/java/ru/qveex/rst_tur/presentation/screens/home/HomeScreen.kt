package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.lists.*
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    sharedViewModel.changeScreenTitle(Screen.Home.title)
    LazyColumn {
        item { FoodList(foods = homeViewModel.foods) }
        item { RoomList(rooms = homeViewModel.rooms) }
        item { FunList(funs = homeViewModel.funs) }
        item { BlogList(blogs = homeViewModel.blogs) }
        item { KidList(kids = homeViewModel.kids) }
    }
}