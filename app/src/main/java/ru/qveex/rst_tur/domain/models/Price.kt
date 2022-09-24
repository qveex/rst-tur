package ru.qveex.rst_tur.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val factPrice: Int,
    val price: Int,
    val discount: String?,
    val currency: String,
    val typePrice: String
)
