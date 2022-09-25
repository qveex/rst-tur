package ru.qveex.rst_tur.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.qveex.rst_tur.domain.interactors.Interactors
import ru.qveex.rst_tur.domain.models.Fun
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {

    private val interactor = interactors.homeInteractor

    private val _foods = mutableStateListOf<Fun>()
    val foods get() = _foods

    init {
        getFoods()
    }

    fun getFoods() {
        viewModelScope.launch {
            val response = interactor.getFuns(id = 117, type = "food")
            Log.i("FOODS", "response = $response")
            if (response.success) {
                response.data.forEach {
                    Log.i("FOODS", "food = $it")
                }
                _foods.addAll(response.data)
            } else {

            }
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