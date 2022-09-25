package ru.qveex.rst_tur.presentation.screens.blog

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.qveex.rst_tur.domain.interactors.Interactors
import ru.qveex.rst_tur.domain.models.BlogInfo
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {
    val interactor = interactors.blogInteractor

    private val _blog = mutableStateOf<BlogInfo?>(null)
    val blog get() = _blog

    fun getBlog(blogId: Int) {
        viewModelScope.launch {
            val response = interactor(id = 117, blogId = blogId)
            if (response.success) {
                Log.i("BlogViewModel", "blog = ${response.data}")
                _blog.value = response.data
            } else {

            }
        }
    }

}