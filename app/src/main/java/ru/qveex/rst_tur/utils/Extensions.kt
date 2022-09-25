package ru.qveex.rst_tur.utils

fun String.translateCurrency() = when(this) {
    "RUB" -> "₽"
    else -> ""
}

fun String.translateTypePrice() = when(this) {
    "night" -> "ночь"
    else -> ""
}