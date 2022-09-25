package ru.qveex.rst_tur.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.qveex.rst_tur.domain.interactors.Interactors
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {

    private val interactor = interactors.homeInteractor

    fun getFoods() {
        viewModelScope.launch {
            interactor.getFuns(id = 117, type = "food")
        }
    }

    fun getTours() {
        viewModelScope.launch {
            interactor.getTours(id = 117)
        }
    }

    fun getRooms() {
        viewModelScope.launch {
            interactor.getRooms(id = 117)
        }
    }

    fun getPlaces() {
        viewModelScope.launch {
            interactor.getFuns(id = 117, type = "place")
        }
    }
}