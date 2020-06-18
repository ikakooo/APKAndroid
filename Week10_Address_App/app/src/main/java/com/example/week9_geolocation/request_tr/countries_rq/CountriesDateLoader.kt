package com.example.week9_geolocation.request_tr.countries_rq

import com.example.week9_geolocation.activities.AddressesSearchActivity
import com.example.week9_geolocation.models.countries_request_json_parsing_models.CountriesJSonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

object CountriesDateLoader {
    private const val COUNTRY_URL_API = "https://run.mocky.io/v3/"
    const val COUNTRY_API_AUTOCOMPLETE = "90aa5377-649b-4e39-ab7c-fa6a21a6882d"

    private val retrofit =
        Retrofit.Builder().baseUrl(COUNTRY_URL_API).addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service = retrofit.create(
        APIService::class.java)

    fun getRequest(
        path: String,
        parameters: MutableMap<String, String>,
        callback: FutureCallbackCountryBridge,
        addressesSearchActivity: AddressesSearchActivity
    ) {
        val call = CountriesDateLoader.service.getCountriesRequest(path, parameters)
        call.enqueue(object : Callback<CountriesJSonModel> {
            override fun onFailure(call: Call<CountriesJSonModel>, t: Throwable) {
                callback.onFailure(t.message.toString())
            }

            override fun onResponse(
                call: Call<CountriesJSonModel>,
                response: Response<CountriesJSonModel>
            ) {
                callback.onResponse(response.body())
            }

        })
    }

    interface APIService {
        @GET("{path}")
        fun getCountriesRequest(@Path("path") path: String, @QueryMap parameters: MutableMap<String, String>): Call<CountriesJSonModel>
    }
}
