package ru.qveex.rst_tur.models

import kotlinx.serialization.Serializable

@Serializable
data class MainObject(
    val buttons: List<Button>,
    val content: List<MainObjectItem>
)
