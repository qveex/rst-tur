package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Blog(
    val id: Int,
    val url: String? = null,
    val image: Image,
    val title: String,
    val subtitle: String,
    val view: Int? = null,
    val like: Int,
    val date: Date,
    val content: String? = null
)
