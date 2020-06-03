package com.example.midterm.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log.d
import com.bumptech.glide.Glide
import com.example.midterm.R
import com.example.midterm.activities.notes.LogInNotesActivity

import com.example.midterm.adapters.SetFragmentsOnViewpager
import com.example.midterm.request.exchange.jsonVariables
import com.example.midterm.request.weather.jsonWeatherVariables

import com.example.midterm.responce.exchange.ExchangeRatesJsonModel
import com.example.midterm.responce.weather.WeatherApiModelJSon
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.fragment_week_day_weather_on_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherActivity : AppCompatActivity() {
    var add = 0
    var count = 0
    private val WEATHERDAYS = 13


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        init()
        initFragmentWithAdapter()

    }


    private fun initFragmentWithAdapter() {
        jsonVariables.enqueue(object : Callback<ExchangeRatesJsonModel> {
            override fun onFailure(call: Call<ExchangeRatesJsonModel>, t: Throwable) {

            }

            @SuppressLint("SetTextI18n")
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





    }

    @SuppressLint("SetTextI18n")
    private fun init() {


        jsonWeatherVariables.enqueue(object : Callback<WeatherApiModelJSon> {
            override fun onFailure(call: Call<WeatherApiModelJSon>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<WeatherApiModelJSon>,
                response: Response<WeatherApiModelJSon>
            ) {
                if (response.isSuccessful) {
                    val WeatherApiResponse = response.body()

                     Handler().postDelayed(({

                         val imageContainer = mutableListOf<Int>()
                         val nameContainer = mutableListOf<String>()
                         val temperatureContainer = mutableListOf<Int>()
                         val windSpeedContainer = mutableListOf<String>()
                         val windDirectionContainer = mutableListOf<String>()
                         val imageURLContainer = mutableListOf<String>()
                         val shortForecastContainer = mutableListOf<String>()
                         val detailedForecastContainer = mutableListOf<String>()




                         for (i in 0..WEATHERDAYS){
                             val name = WeatherApiResponse!!.properties.periods[i].name.toString()
                             val temperature = WeatherApiResponse.properties.periods[i].temperature.toInt()
                             val windSpeed =  WeatherApiResponse.properties.periods[i].windSpeed.toString()
                             val windDirection = WeatherApiResponse.properties.periods[i].windDirection.toString()
                             val iconURl = WeatherApiResponse.properties.periods[i].icon.toString()
                             val shortForecast = WeatherApiResponse.properties.periods[i].shortForecast.toString()
                             val detailedForecast = WeatherApiResponse.properties.periods[i].detailedForecast.toString()
                             imageContainer.add(R.mipmap.iconfinder_weathe)
                             nameContainer.add(name)
                             temperatureContainer.add(temperature)
                             windSpeedContainer.add(windSpeed)
                             windDirectionContainer.add(windDirection)
                             imageURLContainer.add(iconURl)
                             shortForecastContainer.add(shortForecast)
                             detailedForecastContainer.add(detailedForecast)

                         }






                         val adapter = SetFragmentsOnViewpager(supportFragmentManager, count)
                         adapter.imageContainerOnScreen = imageContainer
                         adapter.nameContainerOnScreen = nameContainer
                         adapter.temperatureContainerOnScreen  = temperatureContainer
                         adapter.windSpeedContainerOnScreen = windSpeedContainer
                         adapter.windDirectionContainerOnScreen = windDirectionContainer
                         adapter.imageURLContainerOnScreen = imageURLContainer
                         adapter.shortForecastContainerOnScreen = shortForecastContainer
                         adapter.detailedForecastContainerOnScreen = detailedForecastContainer
                         viewpagerID.adapter = adapter

                         //imageContainerOnScreen.add(imageContainer[1])
                         adapter.notifyDataSetChanged()
                     }),1)


                }
            }

        })
        buttonID.setOnClickListener() {
            startActivity(Intent(this, LogInNotesActivity::class.java))


        }
    }

}