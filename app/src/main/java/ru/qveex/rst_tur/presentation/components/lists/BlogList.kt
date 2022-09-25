package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.qveex.rst_tur.domain.models.Blog
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.list_items.BlogItem

@Composable
fun BlogList(
    blogs: List<Blog>,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.heightIn(min = 0.dp, max = 1000.dp),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "Блог",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(blogs) { blog ->
            BlogItem(blog = blog, onBlogClick = { navController.navigate(Screen.Blog.passId(blog.id)) })
        }
    }
}