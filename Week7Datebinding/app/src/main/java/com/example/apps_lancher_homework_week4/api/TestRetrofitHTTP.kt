package com.example.apps_lancher_homework_week4.api

import com.example.apps_lancher_homework_week4.interfacesBox.httpToJSON
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class TestRetrofitHTTP {


    var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://reqres.in/api/users?page=1")
        .build()

    var service = retrofit.create(GitHubService::class.java)
fun httpRequestJS(path: String, callback: httpToJSON){
    val call = service.httpRequestJS(path)
    call.enqueue(object: Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            callback.onResponse(response.body().toString())
        }


    })
}


    interface GitHubService {
        @GET("{path}")
        fun httpRequestJS(@Path("path") user: String): Call<String>
    }
}