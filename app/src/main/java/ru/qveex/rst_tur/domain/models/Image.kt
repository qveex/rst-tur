package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val sm: String,
    val md: String,
    val lg: String
)
