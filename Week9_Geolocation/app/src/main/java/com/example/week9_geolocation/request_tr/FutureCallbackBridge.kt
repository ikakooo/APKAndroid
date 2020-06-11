package com.example.week9_geolocation.request_tr

import com.example.week9_geolocation.models.LocationJSonModel

interface FutureCallbackBridge {
    fun onResponse(response: LocationJSonModel?)
    fun onFailure(error: String)
}