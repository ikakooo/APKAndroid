package com.example.week5_http_status_codes_hendling.api

import android.util.Log.d
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*


object HttpsRequest {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api")
        .build()

    private var service = retrofit.create(SingInHttpsRequest::class.java)


    fun getRequest(path: String, callback: MyCallback) {
        val call = service.getRequest(path)
        call.enqueue(onCallBack(callback))
    }


    fun postRequest(path: String, mapOFF: MutableMap<String, String>, callback: MyCallback) {
        val call = service.postRequest(path, mapOFF)
        call.enqueue(onCallBack(callback))
    }

    private fun onCallBack(callback: MyCallback) = object : Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            callback.onFailure(t.message.toString())
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            if (response.isSuccessful) {

                callback.onResponse(response.body().toString())
            } else {

                val json = JSONObject(response.errorBody()!!.string())

                if (json.has("error")) {
                    callback.onResponse(json.toString())
                }
            }
        }
    }

    interface SingInHttpsRequest {
        @GET("users/{user}/repos")
        fun getRequest(@Path("user") user: String?): Call<String>

        @FormUrlEncoded
        @POST("{path}")
        fun postRequest(@Path("path") path: String, @FieldMap parameters: Map<String, String>): Call<String>
    }
}