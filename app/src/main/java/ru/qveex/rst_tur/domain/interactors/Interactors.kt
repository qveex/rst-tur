package ru.qveex.rst_tur.domain.interactors

data class Interactors(
    val blogInteractor: BlogInteractor,
    val bookingInteractor: BookingInteractor,
    val chatsInteractor: ChatsInteractor,
    val homeInteractor: HomeInteractor,
    val profileInteractor: ProfileInteractor,
    val mapInteractor: MapInteractor,
    val splashInteractor: SplashInteractor
)
