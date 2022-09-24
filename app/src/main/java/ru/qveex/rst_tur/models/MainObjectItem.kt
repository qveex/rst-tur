package ru.qveex.rst_tur.models

import kotlinx.serialization.Serializable

@Serializable
data class MainObjectItem(
    val title: String,
    val template: Template,
    val url: String
)
