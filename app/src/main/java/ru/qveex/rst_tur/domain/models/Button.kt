package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Button(
    val icon: String,
    val color: String,
    val title: String,
    val type: String,
    val url: String
)
