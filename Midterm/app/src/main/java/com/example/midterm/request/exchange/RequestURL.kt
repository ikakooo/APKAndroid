package com.example.midterm.request.exchange

import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import retrofit2.Call
import retrofit2.http.GET

interface RequestURL {
    @GET("latest")
    fun getJSonRequest(): Call<ExchangeRatesJsonModel>
}