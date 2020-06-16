package com.example.week9_geolocation.models.geolocation_request_json_parsing_models

data class LocationJSonModel(
    val predictions: List<Prediction>,
    val status: String
)