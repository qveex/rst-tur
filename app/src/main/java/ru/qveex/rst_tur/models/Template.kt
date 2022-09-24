package ru.qveex.rst_tur.models

import kotlinx.serialization.Serializable

@Serializable
data class Template(
    val card: String,
    val `object`: String,
    val size: String,
    val direction: String
)
