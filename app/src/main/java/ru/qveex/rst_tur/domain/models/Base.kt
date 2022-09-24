package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Base(
    val id: Int,
    val name: String,
    val url: String
)
