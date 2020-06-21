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
import com.example.week9_geolocation.models.countries_request_json_parsing_models.CountriesJSonModel
import com.example.week9_geolocation.request_tr.countries_rq.CountriesDateLoader
import com.example.week9_geolocation.request_tr.countries_rq.FutureCallbackCountryBridge
import com.example.week9_geolocation.request_tr.location_rq.FutureCallbackBridge
import com.example.week9_geolocation.request_tr.location_rq.LocationDataLoader
import kotlinx.android.synthetic.main.activity_search_addresses.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AddressesSearchActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private val items = mutableListOf<SearchResultAdapter_Model>()

    companion object {
        const val API_KEY = "AIzaSyBADWUmhO9XNVF_-qSZR6RQWcoHfSpAr6E"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_addresses)

        init()
       // countriesRequest()
    }

    private fun init() {
        setSupportActionBar(toolbarID)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        recyclerViewAdapter = RecyclerViewAdapter(items)
        RecyclerviewID.layoutManager = LinearLayoutManager(this)
        RecyclerviewID.adapter = recyclerViewAdapter
        searchLocationID.addTextChangedListener(textWatcher)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


    private fun addressRequest(input: String) {
        var countryID= intent.extras?.getString("countryID")

        val parameters = mutableMapOf<String, String>()
        parameters["input"] = input
        parameters["key"] = API_KEY
        parameters["language"] = "en"
        parameters["components"]="country:$countryID"
        LocationDataLoader.getRequest(
            LocationDataLoader.AUTOCOMPLETE,
            parameters,
            object : FutureCallbackBridge {
                override fun onResponse(response: LocationJSonModel?) {
                    if (response != null) {
                        items.clear()
                        if (response.predictions.isNotEmpty()) {
                            val setItems = response.predictions.size
                            d("sdSDfdfsdf",setItems.toString())
                            (0 until setItems).forEach {
                                items.add(SearchResultAdapter_Model(response.predictions[it].description.toString(), response.predictions[it].place_id.toString()
                                    )
                                )
                            }
                            recyclerViewAdapter.notifyDataSetChanged()
                        } else {
                            onFailure(response.toString())
                        }
                    }


                }

                override fun onFailure(error: String) {
                    d("logerrorrr", error)
                }

            })



    }





    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(inputText: Editable?) {
        }

        override fun beforeTextChanged(
            inputText: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(inputText: CharSequence?, start: Int, before: Int, count: Int) {
            addressRequest(inputText.toString())
        }

    }


}
