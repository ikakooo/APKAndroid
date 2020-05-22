package com.example.apps_lancher_homework_week4.api

import com.example.apps_lancher_homework_week4.models.Bands
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
class HttpRequestForGettingBands {


    interface RetrofitCalls {
        @GET("lnjb8")
        fun findPosts(): Call<List<Bands>>
    }

    var myRetrofit = Retrofit.Builder()
        .baseUrl("https://www.mocky.io/v2/5ec3ab0f300000850039c29e")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //val repository = myRetrofit.create(RetrofitCalls::class.java)

//    fun main(args: Array<String>) {
//        val call = repository.findPosts()
//        val variables = call.execute().body()
//
//        variables?.forEach {
//            println(it)
//        }
//    }
}