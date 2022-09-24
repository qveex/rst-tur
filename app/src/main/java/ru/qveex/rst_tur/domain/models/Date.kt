package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Date(
    val typeDate: String,
    val date: String?
)
