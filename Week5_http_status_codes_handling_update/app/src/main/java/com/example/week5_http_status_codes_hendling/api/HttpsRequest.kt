package com.example.week5_http_status_codes_hendling.api

import android.util.Log.d
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*


object HttpsRequest {

    const val UNKNOW = "unknown"
    const val URL = "https://reqres.in/api/"

    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(URL)
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
            d("httprequestfale", "${t.message}")
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            when(response.code()){
                200 -> callback.onResponse(response.body().toString())
                201 -> callback.onResponse(response.body().toString())
                400-> try {
                    val json = JSONObject(response.errorBody()!!.string())
                    if (json.has("error")) { callback.onResponse(json.toString())}
                    }catch (e: JSONException){ }
                500-> callback.onResponse(response.body().toString())



            }

        }
    }

    interface SingInHttpsRequest {
        @GET("{path}")
        fun getRequest(@Path("path") user: String?): Call<String>

        @FormUrlEncoded
        @POST("{path}")
        fun postRequest(@Path("path") path: String, @FieldMap parameters: Map<String, String>): Call<String>
    }
}