package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Blog(
    val id: Int,
    val image: Image,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: Date
)
