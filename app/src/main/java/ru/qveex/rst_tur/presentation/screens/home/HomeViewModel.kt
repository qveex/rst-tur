package ru.qveex.rst_tur.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.qveex.rst_tur.domain.interactors.Interactors
import ru.qveex.rst_tur.domain.models.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {

    private val interactor = interactors.homeInteractor

    private val _buttons = mutableStateListOf<Button>()
    val buttons get() = _buttons

    private val _foods = mutableStateListOf<Fun>()
    val foods get() = _foods

    private val _tours = mutableStateListOf<Tour>()
    val tours get() = _tours

    private val _rooms = mutableStateListOf<Room>()
    val rooms get() = _rooms

    private val _places = mutableStateListOf<Fun>()
    val places get() = _places

    private val _funs = mutableStateListOf<Fun>()
    val funs get() = _funs

    private val _kids = mutableStateListOf<Fun>()
    val kids get() = _kids

    private val _blogs = mutableStateListOf<Blog>()
    val blogs get() = _blogs


    init {
        getMainObjects()
        getFoods()
        getRooms()
        getFuns()
        getTours()
        getPlaces()
        getKids()
        getBlogs()
    }

    private fun getMainObjects() {
        viewModelScope.launch {
            try {
                val response = interactor.getMainObjects(id = 117)
                if (response.success) {
                    Log.i("HomeViewModel", "mainObjects = ${response.data}")
                    _buttons.addAll(response.data.buttons)
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getFoods() {
        viewModelScope.launch {
            try {
                val response = interactor.getFuns(id = 117, type = "food")
                if (response.success) {
                    Log.i("HomeViewModel", "foods = ${response.data}")
                    _foods.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getTours() {
        viewModelScope.launch {
            try {
                val response = interactor.getTours(id = 117)
                if (response.success) {
                    _tours.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getRooms() {
        viewModelScope.launch {
            try {
                val response = interactor.getRooms(id = 117)
                if (response.success) {
                    Log.i("HomeViewModel", "rooms = ${response.data}")
                    _rooms.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getPlaces() {
        viewModelScope.launch {
            try {
                val response = interactor.getFuns(id = 117, type = "place")
                if (response.success) {
                    _places.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getFuns() {
        viewModelScope.launch {
            try {
                val response = interactor.getFuns(id = 117, type = "fun")
                if (response.success) {
                    Log.i("HomeViewModel", "funs = ${response.data}")
                    _funs.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getKids() {
        viewModelScope.launch {
            try {
                val response = interactor.getFuns(id = 117, type = "child")
                if (response.success) {
                    Log.i("HomeViewModel", "kids = ${response.data}")
                    _kids.addAll(response.data.subList(0, 2))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }

    private fun getBlogs() {
        viewModelScope.launch {
            try {
                val response = interactor.getBlogs(id = 117, format = "card")
                if (response.success) {
                    Log.i("HomeViewModel", "blogs = ${response.data}")
                    _blogs.addAll(response.data.subList(0, 6))
                } else {

                }
            } catch (e: Exception) { return@launch }

        }
    }
}