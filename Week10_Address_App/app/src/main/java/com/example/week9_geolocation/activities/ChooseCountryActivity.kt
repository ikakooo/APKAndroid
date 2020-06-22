package com.example.week9_geolocation.activities

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week9_geolocation.R
import com.example.week9_geolocation.adapters.CountryRecyclerViewAdapter
import com.example.week9_geolocation.models.adapters_models.SearchCountriesAdapterModel
import com.example.week9_geolocation.models.countries_request_json_parsing_models.CountriesJSonModel
import com.example.week9_geolocation.request_tr.countries_rq.CountriesDateLoader
import com.example.week9_geolocation.request_tr.countries_rq.FutureCallbackCountryBridge
import kotlinx.android.synthetic.main.activity_choose_country.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class ChooseCountryActivity : AppCompatActivity() {
    private lateinit var countryRecyclerViewAdapter: CountryRecyclerViewAdapter
    private val countries = mutableListOf<SearchCountriesAdapterModel>()
    private var countryName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_country)
        init()
    }



    private fun init(){
        setSupportActionBar(toolbarID)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        ToolbarTextViewID.text = getString(R.string.Save)



        countryRecyclerViewAdapter = CountryRecyclerViewAdapter(countries)
        CountriesRecyclerviewID.layoutManager = LinearLayoutManager(this)
        CountriesRecyclerviewID.adapter = countryRecyclerViewAdapter
        countriesRequest()
        saveOrBack()
    }



    private fun countriesRequest() {
        val parameters = mutableMapOf<String, String>()

        CountriesDateLoader.getRequest(
            CountriesDateLoader.COUNTRY_API_AUTOCOMPLETE,parameters,
            object : FutureCallbackCountryBridge {
                override fun onResponse(response: CountriesJSonModel?) {
                    val countOfCountries = response!!.results.size
                    (0 until countOfCountries).forEach { it ->
                        countries.add(SearchCountriesAdapterModel(response.results[it].iso2.toString(),response.results[it].name.toString()))
                    }
                    countryRecyclerViewAdapter.notifyDataSetChanged()
                }

                override fun onFailure(error: String) {
                    Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_SHORT).show()
                    val toast = Toast.makeText(applicationContext, "Hello Javatpoint", Toast.LENGTH_LONG)
                    toast.show()
                    val myToast = Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.TOP,200,200)
                    myToast.show()
                }


            },
            this
        )
    }


    private fun saveOrBack(){



        ToolbarTextViewID.setOnClickListener {

            val myintent = Intent(this, AddressActivity::class.java)
            //val returnIntent = this.intent
            myintent.putExtra("samplename", countryRecyclerViewAdapter.selectedCountryAbbreviation)
            myintent.putExtra("samplenameID", countryRecyclerViewAdapter.selectedCountryAbbreviationID)
            setResult(Activity.RESULT_OK, myintent)
            super.onBackPressed()
        }
    }



}