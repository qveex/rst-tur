package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.lists.FoodList
import ru.qveex.rst_tur.presentation.components.lists.RoomList
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    sharedViewModel.changeScreenTitle(Screen.Home.title)
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        FoodList(foods = homeViewModel.foods)
        RoomList(rooms = homeViewModel.rooms)
    }
}