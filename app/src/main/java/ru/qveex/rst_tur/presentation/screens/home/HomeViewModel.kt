package ru.qveex.rst_tur.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.qveex.rst_tur.domain.interactors.Interactors
import ru.qveex.rst_tur.domain.models.*
import ru.qveex.rst_tur.utils.AppStatus
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }
    
    private val interactor = interactors.homeInteractor

    private val _status = mutableStateOf<AppStatus<String, String>>(AppStatus.Idle)
    val status get() = _status.value

    // TODO HomeViewState
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
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getMainObjects(id = 117)
                if (response.success) {
                    Log.i(TAG, "mainObjects = ${response.data}")
                    _buttons.addAll(response.data.buttons)
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getFoods() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getFuns(id = 117, type = "food")
                if (response.success) {
                    Log.i(TAG, "foods = ${response.data}")
                    _foods.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }
        }
    }

    private fun getTours() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getTours(id = 117)
                if (response.success) {
                    _tours.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getRooms() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getRooms(id = 117)
                if (response.success) {
                    Log.i(TAG, "rooms = ${response.data}")
                    _rooms.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getPlaces() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getFuns(id = 117, type = "place")
                if (response.success) {
                    _places.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getFuns() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getFuns(id = 117, type = "fun")
                if (response.success) {
                    Log.i(TAG, "funs = ${response.data}")
                    _funs.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getKids() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getFuns(id = 117, type = "child")
                if (response.success) {
                    Log.i(TAG, "kids = ${response.data}")
                    _kids.addAll(response.data.subList(0, 2))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }

    private fun getBlogs() {
        viewModelScope.launch {
            _status.value = AppStatus.Loading()
            _status.value = try {
                val response = interactor.getBlogs(id = 117, format = "card")
                if (response.success) {
                    Log.i(TAG, "blogs = ${response.data}")
                    _blogs.addAll(response.data.subList(0, 6))
                    AppStatus.Success("")
                } else {
                    AppStatus.Error("")
                }
            } catch (e: Exception) { AppStatus.Error("") }

        }
    }
}