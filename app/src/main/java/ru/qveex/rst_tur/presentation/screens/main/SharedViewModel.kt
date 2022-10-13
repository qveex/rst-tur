package ru.qveex.rst_tur.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(

) : ViewModel() {

    private val _isDarkThemeState: MutableState<Boolean> = mutableStateOf(value = false)
    val isDarkThemeState get() = _isDarkThemeState.value
    fun changeThemeState() = run { _isDarkThemeState.value = !_isDarkThemeState.value }

    private val _title: MutableState<String> = mutableStateOf(value = "")
    val title get() = _title
    fun changeScreenTitle(newTitle: String) = run { _title.value = newTitle }
}