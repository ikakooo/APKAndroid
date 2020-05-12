package com.example.week5_http_status_codes_hendling.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


class HttpsRequest {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/users?page=2")
        .build()

    var service = retrofit.create(SingInHttpsRequest::class.java)



    interface SingInHttpsRequest {
        @GET("users/{user}/repos")
        fun getRequest(@Path("user") user: String?): Call<String?>?
    }
}