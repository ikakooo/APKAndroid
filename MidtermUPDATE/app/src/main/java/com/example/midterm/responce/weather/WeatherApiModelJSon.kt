package com.example.midterm.responce.weather

data class WeatherApiModelJSon(
    val geometry: Geometry,
    val properties: Properties,
    val type: String
)