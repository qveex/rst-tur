package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Tour(
    val id: Int,
    val url: String,
    val image: Image,
    val title: String,
    val location: String,
    val date: Date,
    val duration: TourDuration,
    val price: Price,
    val home: Home
)
