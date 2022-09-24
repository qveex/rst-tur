package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Fun(
    val id: Int,
    val image: Image,
    val title: String,
    val subtitle: String
)