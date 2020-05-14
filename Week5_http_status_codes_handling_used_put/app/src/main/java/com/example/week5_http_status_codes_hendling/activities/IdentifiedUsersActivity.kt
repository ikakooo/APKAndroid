package com.example.week5_http_status_codes_hendling.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_http_status_codes_hendling.R
import com.example.week5_http_status_codes_hendling.adapters.DataModelAdapter
import com.example.week5_http_status_codes_hendling.api.HttpsRequest
import com.example.week5_http_status_codes_hendling.api.MyCallback
import com.example.week5_http_status_codes_hendling.models.DataModel
import com.example.week5_http_status_codes_hendling.models.ItemsClass
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_identified_users.*

class IdentifiedUsersActivity : AppCompatActivity() {

    private lateinit var adapter: DataModelAdapter
    private val items = mutableListOf<ItemsClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identified_users)

        init()
    }


    private fun init(){
        adapter =  DataModelAdapter(items)
        scrollViewItems.layoutManager = LinearLayoutManager(this)
        scrollViewItems.adapter =adapter
        //addDate()
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
