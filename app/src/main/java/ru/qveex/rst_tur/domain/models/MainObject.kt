package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class MainObject(
    val buttons: List<Button>,
    val content: List<MainObjectItem>
)
