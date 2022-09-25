package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.FoodList
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    sharedViewModel.changeScreenTitle(Screen.Home.title)
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        FoodList(foods = homeViewModel.foods)
    }
}