package ru.qveex.rst_tur.utils

sealed class AppStatus<out T, out E> {
    data class Success<T>(val data: T): AppStatus<T, Nothing>()
    data class Error<E>(val error: E): AppStatus<Nothing, E>()
    data class Loading(val message: String? = null): AppStatus<Nothing, Nothing>()
    object Idle: AppStatus<Nothing, Nothing>()
}