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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.UpButton
import ru.qveex.rst_tur.presentation.components.list_items.*
import ru.qveex.rst_tur.presentation.components.lists.*
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.presentation.screens.splash.HideUIVisibilityState

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    HideUIVisibilityState(state = true)
    val systemUiController = rememberSystemUiController()
    val backgroundColor = MaterialTheme.colors.background
    LaunchedEffect(Unit) {
        sharedViewModel.changeScreenTitle(Screen.Home.title)
        systemUiController.setSystemBarsColor(backgroundColor)
    }

    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 14.dp, start = 14.dp, end = 14.dp),
        state = listState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        single {
            Text(
                text = "Питание",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        items(items = homeViewModel.foods) { food ->
            FoodItem(food = food)
        }

        single {
            Text(
                text = "Отели",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        singleList(items = homeViewModel.rooms) { room ->
            RoomItem(room = room)
        }

        single {
            FunList(funs = homeViewModel.funs)
        }

        single {
            Text(
                text = "Блог",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        singleList(homeViewModel.blogs) { blog ->
            BlogItem(blog = blog) { navController.navigate(Screen.Blog.passId(blog.id)) }
        }

        single {
            Text(
                text = "Для детей",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }

        singleList(homeViewModel.kids) { kid ->
            KidItem(kid = kid)
        }

        single {
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
}


private inline fun LazyGridScope.single(crossinline itemContent: @Composable (LazyGridItemScope.() -> Unit)) {
    item(
        span = { GridItemSpan(maxCurrentLineSpan) }
    ) {
        itemContent()
    }
}

private inline fun <T> LazyGridScope.singleList(items: List<T>, crossinline listContent: @Composable ((T) -> Unit)) {
    items(
        span = { GridItemSpan(maxCurrentLineSpan) },
        items = items
    ) { item ->
        listContent(item)
    }
}