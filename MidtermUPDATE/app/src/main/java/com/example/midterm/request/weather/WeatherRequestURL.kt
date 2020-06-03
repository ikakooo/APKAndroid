package com.example.midterm.request.weather

import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import com.example.midterm.responce.weather.WeatherApiModelJSon
import retrofit2.Call
import retrofit2.http.GET


interface WeatherRequestURL {
    @GET("forecast")
    fun getJSonWeatherRequest(): Call<WeatherApiModelJSon>
}