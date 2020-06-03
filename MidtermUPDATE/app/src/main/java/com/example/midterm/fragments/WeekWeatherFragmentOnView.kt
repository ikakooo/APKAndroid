package com.example.midterm.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.midterm.R
import kotlinx.android.synthetic.main.fragment_week_day_weather_on_view.*
import kotlinx.android.synthetic.main.fragment_week_day_weather_on_view.view.*


class WeekWeatherFragmentOnView(
    var img: Int,
    var namee: String,
    var temperature: Int,
    var windSpeed: String,
    var windDirection: String,
    var iconURl: String,
    var shortForecast: String,
    var detailedForecast: String,
    var position: Int
) : Fragment() {
    lateinit var itemView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        itemView = inflater.inflate(R.layout.fragment_week_day_weather_on_view, container, false)
        addimg()
        return itemView
    }

    @SuppressLint("SetTextI18n")
    private fun addimg() {
        Handler().postDelayed(({
            Glide.with(itemView.context).load(iconURl).into(WeatherImageViewId)
            itemView.weatherDayTextViewID.text = namee
            itemView.weatherTemperatureTextViewID.text = ((temperature.toInt()-32)*(0.5556)).toInt().toString() + " C"
            itemView.windSpeedTextView.text = "WS: $windSpeed"
            itemView.windDirectionTextView.text = "WD: $windDirection"


        }), 500)
        itemView.WeatherImageViewId.setOnClickListener(){
            Toast.makeText(context, shortForecast, Toast.LENGTH_LONG).show()
        }
//        itemView.imageButtonID.setImageResource(img)
        // itemView.textViewOnPhotoID.text = "Day: "+(position+1).toString()
        //Glide.with(itemView.context).load(url).into(WeatherImageViewId)
        //  Glide.with(itemView.context).load(position.avatar).into(itemView.imageButtonID)


    }

}
