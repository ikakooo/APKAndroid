package com.example.week9_geolocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.week9_geolocation.models.LocationJSonModel
import com.example.week9_geolocation.request_tr.FutureCallbackBridge
import com.example.week9_geolocation.request_tr.LocationDataLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private val items = mutableListOf<LocationJSonModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        recyclerViewAdapter = RecyclerViewAdapter(items)
        RecyclerviewID.layoutManager = LinearLayoutManager(this)
        RecyclerviewID.adapter = recyclerViewAdapter
        searchLocationID.addTextChangedListener(textWatcher)
    }





    private fun AddressRequest(input: String) {

        val parameters = mutableMapOf<String, String>()
        parameters["input"] = input
        parameters["key"] = Companion.API_KEY
        LocationDataLoader.getRequest(LocationDataLoader.AUTOCOMPLETE,parameters,object : FutureCallbackBridge{
            override fun onResponse(response: LocationJSonModel?) {
                val setItems = response!!.predictions.size
                (0 until setItems).forEach{
                       d("sdkjfsdjf", response.predictions[it].description.toString())
                    }
            }

            override fun onFailure(error: String) {
                d("logerror", error)
            }

        })









//        jsonVariables.enqueue(object : Callback<LocationJSonModel> {
//            override fun onFailure(call: Call<LocationJSonModel>, t: Throwable) {
//
//            }
//
//            @SuppressLint("SetTextI18n")
//            override fun onResponse(
//                call: Call<LocationJSonModel>,
//                response: Response<LocationJSonModel>
//            ) {
//
//                if (response.isSuccessful) {
//                    val mResponse = response.body()
//                    val setItems = mResponse!!.predictions.size
//                    (0 until setItems).forEach{
//                      // d("sdkjfsdjf",mResponse!!.predictions[it].description.toString())
//                    }
//
//                }
//            }
//        })
    }


    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(inputText: Editable?) {
        }

        override fun beforeTextChanged(inputText: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(inputText: CharSequence?, start: Int, before: Int, count: Int) {
            AddressRequest(inputText.toString())
        }

    }

    companion object {
        const val API_KEY = "AIzaSyBukqO846TNjXqU_Mc_kAFFaC3Wdt-PFaU"
    }


}
