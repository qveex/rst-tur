package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Error(
    val name: String,
    val status: String,
    val code: String,
    val message: String
)
