package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id: Int,
    val url: String? = null,
    val image: Image,
    val title: String,
    val location: String? = null,
    val subtitle: String? = null,
    val date: Date,
    val duration: Duration,
    val price: Price,
    val countTourist: Int,
    val view: String? = null,
    val type: String
)
