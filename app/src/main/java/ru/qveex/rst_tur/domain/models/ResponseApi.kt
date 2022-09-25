package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseApi<T>(
    val success: Boolean,
    val error: Error?,
    val time: String,
    val data: T
)
