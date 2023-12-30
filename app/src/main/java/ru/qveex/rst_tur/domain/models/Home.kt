package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Home(
    val id: Int,
    val name: String,
    val type: String,
    val night: Int? = null,
    val url: String,
    val image: Image,
    val base: Base
)
