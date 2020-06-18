package com.example.week9_geolocation.request_tr.countries_rq

import com.example.week9_geolocation.models.countries_request_json_parsing_models.CountriesJSonModel

interface FutureCallbackCountryBridge {
    fun onResponse(response: CountriesJSonModel?)
    fun onFailure(error: String)
}