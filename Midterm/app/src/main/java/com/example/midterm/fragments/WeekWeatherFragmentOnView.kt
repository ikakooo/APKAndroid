package com.example.midterm.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midterm.R
import kotlinx.android.synthetic.main.fragment_week_day_weather_on_view.view.*


class  WeekWeatherFragmentOnView(var img: Int, var position:Int) : Fragment() {
    lateinit var itemView:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        itemView =inflater.inflate(R.layout.fragment_week_day_weather_on_view, container, false)
        addimg()
        return itemView
    }
    @SuppressLint("SetTextI18n")
    private  fun addimg(){
//        itemView.imageButtonID.setImageResource(img)
        itemView.textViewOnPhotoID.text = "ikakooo "+(position+1).toString()
//        //Glide.with(itemView.context).load(position.avatar).into(itemView.imageButtonID)
    }

}
