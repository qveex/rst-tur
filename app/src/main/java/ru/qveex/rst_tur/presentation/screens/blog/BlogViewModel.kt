package ru.qveex.rst_tur.presentation.screens.blog

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.qveex.rst_tur.domain.interactors.Interactors
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {
    val interactor = interactors.blogInteractor
}