package com.example.midterm.responce.exchange

data class ExchangeRatesJsonModel(
    val base: String,
    val date: String,
    val rates: Rates
)