package com.ikakooo.shopapp.request_https

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserDateLoader {
    private const val COUNTRY_URL_API = "https://ktorhighsteaks.herokuapp.com"
    const val COUNTRY_API_AUTOCOMPLETE = "/register"

    private val retrofit =
        Retrofit.Builder().baseUrl(COUNTRY_URL_API).addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service = retrofit.create(
        APIUsersServices::class.java)

//    fun getRequest(
//        path: String,
//        parameters: MutableMap<String, String>,
//        callback: FutureCallbackCountryBridge
//    ) {
//        val call = UserDateLoader.service.getListRepos(path, parameters)
//        call!!.enqueue(object : Callback<String> {
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                callback.onFailure(t.message.toString())
//            }
//
//            override fun onResponse(
//                call: Call<String>,
//                response: Response<String>
//            ) {
//                callback.onResponse(response.body())
//            }
//
//        })
//    }
//
//



}