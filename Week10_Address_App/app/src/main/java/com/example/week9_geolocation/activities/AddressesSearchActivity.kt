package com.example.week9_geolocation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week9_geolocation.R
import com.example.week9_geolocation.adapters.RecyclerViewAdapter

import com.example.week9_geolocation.models.geolocation_request_json_parsing_models.LocationJSonModel
import com.example.week9_geolocation.models.adapters_models.SearchResultAdapter_Model
import com.example.week9_geolocation.request_tr.FutureCallbackBridge
import com.example.week9_geolocation.request_tr.LocationDataLoader
import kotlinx.android.synthetic.main.activity_search_addresses.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AddressesSearchActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private val items = mutableListOf<SearchResultAdapter_Model>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_addresses)

        init()
    }

    private fun init() {
        setSupportActionBar(toolbarID)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        recyclerViewAdapter = RecyclerViewAdapter(items)
        RecyclerviewID.layoutManager = LinearLayoutManager(this)
        RecyclerviewID.adapter = recyclerViewAdapter
        searchLocationID.addTextChangedListener(textWatcher)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }



    private fun AddressRequest(input: String) {

        val parameters = mutableMapOf<String, String>()
        parameters["input"] = input
        parameters["key"] = API_KEY
        LocationDataLoader.getRequest(LocationDataLoader.AUTOCOMPLETE,parameters,object : FutureCallbackBridge{
            override fun onResponse(response: LocationJSonModel?) {
                if (response != null) {
                    items.clear()
                    if (response.predictions.isNotEmpty()) {
                        val setItems = response.predictions.size
                        (0 until setItems).forEach {
                            val jsonPrediction = response.predictions[it]
                            d("sdkjfsdjfsdfss", response.toString())
                            items.add(SearchResultAdapter_Model( jsonPrediction.description.toString() , jsonPrediction.place_id.toString() )
                            )
                        }
                        recyclerViewAdapter.notifyDataSetChanged()
                    } else  {
                        onFailure( response.toString())
                    }
                }



            }

            override fun onFailure(error: String) {
                d("logerrorrr", error)
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
        const val API_KEY = "AIzaSyBADWUmhO9XNVF_-qSZR6RQWcoHfSpAr6E"
    }


}
