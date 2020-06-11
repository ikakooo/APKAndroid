package com.example.week9_geolocation.models

data class LocationJSonModel(
    val predictions: List<Prediction>,
    val status: String
)