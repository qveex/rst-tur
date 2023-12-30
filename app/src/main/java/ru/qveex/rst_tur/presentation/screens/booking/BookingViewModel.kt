package ru.qveex.rst_tur.presentation.screens.booking

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.qveex.rst_tur.domain.interactors.Interactors
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    interactors: Interactors
) : ViewModel() {
    val interactor = interactors.bookingInteractor
}