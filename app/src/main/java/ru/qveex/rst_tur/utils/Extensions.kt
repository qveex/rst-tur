package ru.qveex.rst_tur.utils

fun String.translateCurrency() = when(this) {
    "RUB" -> "₽"
    else -> ""
}

fun String.translateTypePrice() = when(this) {
    "night" -> "ночь"
    else -> ""
}

fun String.translateMonth() = when(this.substringAfter('-').substringBefore('-')) {
    "01" -> "янв"
    "02" -> "фев"
    "03" -> "март"
    "04" -> "апр"
    "05" -> "май"
    "06" -> "июнь"
    "07" -> "июль"
    "08" -> "авг"
    "09" -> "сен"
    "10" -> "окт"
    "11" -> "нояб"
    "12" -> "дек"
    else -> ""
}

fun String.dateConvert() = this.replace('-', '.').substringBefore('T')