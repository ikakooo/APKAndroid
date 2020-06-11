package com.example.week9_geolocation.request_tr

import com.example.week9_geolocation.models.LocationJSonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

object LocationDataLoader {
    private const val URL_API = "https://maps.googleapis.com/maps/api/"
    const val AUTOCOMPLETE = "autocomplete"

    private val retrofit =
        Retrofit.Builder().baseUrl(URL_API).addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service = retrofit.create(APIService::class.java)

    fun getRequest(path: String, parameters: MutableMap<String, String>, callback: FutureCallbackBridge) {
        val call = service.getRequest(path, parameters)
        call.enqueue(object : Callback<LocationJSonModel> {
            override fun onFailure(call: Call<LocationJSonModel>, t: Throwable) {
                callback.onFailure(t.message.toString())
            }

            override fun onResponse(
                call: Call<LocationJSonModel>,
                response: Response<LocationJSonModel>
            ) {
                callback.onResponse(response.body())
            }

        })
    }

    interface APIService {
        @GET("place/{path}/json")
        fun getRequest(@Path("path") path: String, @QueryMap parameters: Map<String, String>): Call<LocationJSonModel>
    }
}