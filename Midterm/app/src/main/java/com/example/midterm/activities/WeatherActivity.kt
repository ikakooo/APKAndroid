package com.example.midterm.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.R
import com.example.midterm.activities.notes.LogInNotesActivity

import com.example.midterm.adapters.SetFragmentsOnViewpager
import com.example.midterm.request.exchange.jsonVariables

import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherActivity : AppCompatActivity() {
    var add = 0
    var count = 0
    private val WEEKDAYS = 7


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        init()
        initFragmentWithAdapter()

    }


    private fun initFragmentWithAdapter() {
        val imageContainer = mutableListOf<Int>()
        val imageContainerOnScreen = mutableListOf<Int>()
        imageContainerOnScreen.add(R.drawable.ic_launcher_background)
        imageContainer.add(R.mipmap.ic_launcher)
        imageContainer.add(R.mipmap.ic_launcher_background)
        imageContainer.add(R.mipmap.ic_launcher_foreground)
        imageContainer.add(R.mipmap.ic_launcher_round)
        imageContainer.add(R.mipmap.ic_launcher_foreground)
        imageContainer.add(R.mipmap.ic_launcher_round)
        imageContainer.add(R.mipmap.ic_launcher_foreground)
        imageContainer.add(R.mipmap.ic_launcher_round)
        imageContainer.add(R.mipmap.ic_launcher_foreground)
        imageContainer.add(R.mipmap.ic_launcher_round)


        val adapter = SetFragmentsOnViewpager(supportFragmentManager, count)
        adapter.imageconteiner = imageContainerOnScreen
        viewpagerID.adapter = adapter


        imageContainerOnScreen.add(imageContainer[1])
        imageContainerOnScreen.add(imageContainer[2])
        imageContainerOnScreen.add(imageContainer[3])
        adapter.notifyDataSetChanged()

    }

    @SuppressLint("SetTextI18n")
    private fun init() {


        jsonVariables.enqueue(object : Callback<ExchangeRatesJsonModel> {
            override fun onFailure(call: Call<ExchangeRatesJsonModel>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ExchangeRatesJsonModel>,
                response: Response<ExchangeRatesJsonModel>
            ) {

                if (response.isSuccessful) {
                    val mResponse = response.body()
                    USDtextViewID.text = "EUR to USD: " + mResponse!!.rates.USD.toString()
                    EUROtextViewID.text = "EUR to SEK: " + mResponse.rates.SEK.toString()
                    RUBtextViewID.text = "EUR to RUB: " + mResponse.rates.RUB.toString()
                }
            }
        })

        buttonID.setOnClickListener() {
            startActivity(Intent(this, LogInNotesActivity::class.java))


        }
    }
}