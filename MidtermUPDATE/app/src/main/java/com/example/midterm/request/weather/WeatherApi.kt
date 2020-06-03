package com.example.midterm.request.weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val EXCHANGE_API = "https://api.weather.gov/gridpoints/TOP/42,42/"

private val retrofit = Retrofit.Builder()
    .baseUrl(EXCHANGE_API)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private val postsApi = retrofit.create(
    WeatherRequestURL::class.java
)
val jsonWeatherVariables = postsApi.getJSonWeatherRequest()