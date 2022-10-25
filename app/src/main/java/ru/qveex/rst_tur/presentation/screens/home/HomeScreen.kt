package ru.qveex.rst_tur.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.UpButton
import ru.qveex.rst_tur.presentation.components.list_items.*
import ru.qveex.rst_tur.presentation.components.lists.*
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(Screen.Home.title) }
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 14.dp, start = 14.dp, end = 14.dp),
        state = listState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text(
                text = "Питание",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(items = homeViewModel.foods) { food ->
            FoodItem(food = food)
        }


        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text(
                text = "Отели",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(
            span = { GridItemSpan(maxCurrentLineSpan) },
            items = homeViewModel.rooms
        ) { room ->
            RoomItem(room = room)
        }


        // title is already in list
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            FunList(funs = homeViewModel.funs)
        }



        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text(
                text = "Блог",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(
            span = { GridItemSpan(maxCurrentLineSpan) },
            items = homeViewModel.blogs
        ) { blog ->
            BlogItem(blog = blog) { navController.navigate(Screen.Blog.passId(blog.id)) }
        }



        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text(
                text = "Для детей",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(
            span = { GridItemSpan(maxCurrentLineSpan) },
            items = homeViewModel.kids
        ) { kid ->
            KidItem(kid = kid)
        }


        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Text(
                text = "Туры",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(items = homeViewModel.tours) { tour ->
            TourItem(tour = tour)
        }
    }
    UpButton(state = listState)
    /*LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        //item { FoodListFixed(foods = homeViewModel.foods, size = 6) }


        item { FoodList(foods = homeViewModel.foods) }
        item { RoomList(rooms = homeViewModel.rooms) }
        item { FunList(funs = homeViewModel.funs) }
        item { BlogList(blogs = homeViewModel.blogs, navController = navController ) }
        item { KidList(kids = homeViewModel.kids) }
        item { TourList(tours = homeViewModel.tours) }
    }*/
    //UpButton(listState = listState)
}


// TODO fun for single element in grid
// TODO funs for lists