package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id: Int,
    val image: Image,
    val title: String,
    val date: Date,
    val duration: RoomDuration,
    val price: Price,
    val countTourist: Int,
    val type: String
)
