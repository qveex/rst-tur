package ru.qveex.rst_tur.models

data class ResponseApi<T>(
    val success: Boolean,
    val error: String?,
    val time: String,
    val data: T
)
