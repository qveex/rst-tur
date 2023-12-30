package ru.qveex.rst_tur.presentation.screens.map

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.qveex.rst_tur.domain.interactors.Interactors
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {
    val interactor = interactors.mapInteractor
}