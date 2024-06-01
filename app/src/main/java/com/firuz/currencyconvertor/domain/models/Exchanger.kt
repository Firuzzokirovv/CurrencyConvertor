package com.firuz.currencyconvertor.domain.models


data class Exchanger(
    val bankName: String,
    val shortName: String,
    val icon: String,
    val name: String,
    val fullName: String,
    val flag: String,
    val sellValue: Double,
    val buyValue: Double
)