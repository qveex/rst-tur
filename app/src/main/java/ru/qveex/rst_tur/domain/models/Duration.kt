package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Duration(
    val day: Int? = null,
    val night: Int? = null,
    val hour: Int? = null
)
