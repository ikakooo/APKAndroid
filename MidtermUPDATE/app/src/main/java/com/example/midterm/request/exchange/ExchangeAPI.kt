package com.example.midterm.request.exchange



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val EXCHANGE_API = "https://api.exchangeratesapi.io/"

private val retrofit = Retrofit.Builder()
    .baseUrl(EXCHANGE_API)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private val postsApi = retrofit.create(
    RequestURL::class.java)
val jsonVariables = postsApi.getJSonRequest()




