package com.example.week5_http_status_codes_hendling.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5_http_status_codes_hendling.R
import com.example.week5_http_status_codes_hendling.api.HttpsRequest
import com.example.week5_http_status_codes_hendling.api.MyCallback
import com.example.week5_http_status_codes_hendling.models.DataModel
import com.google.gson.Gson

class IdentifiedUsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identified_users)
        ttt()
    }
    private fun ttt(){
        HttpsRequest.getRequest(HttpsRequest.UNKNOW, object : MyCallback {
            override fun onFailure(error: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(response: String) {
                var parsedJSON = Gson().fromJson(response,Array<DataModel>::class.java)
            }

        })

    }
}
