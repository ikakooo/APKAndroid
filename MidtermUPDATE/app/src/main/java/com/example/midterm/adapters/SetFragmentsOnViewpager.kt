package com.example.midterm.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.midterm.fragments.WeekWeatherFragmentOnView

class SetFragmentsOnViewpager(fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    var imageContainerOnScreen = mutableListOf<Int>()
    var nameContainerOnScreen = mutableListOf<String>()
    var temperatureContainerOnScreen = mutableListOf<Int>()
    var windSpeedContainerOnScreen = mutableListOf<String>()
    var windDirectionContainerOnScreen = mutableListOf<String>()
    var imageURLContainerOnScreen = mutableListOf<String>()
    var shortForecastContainerOnScreen = mutableListOf<String>()
    var detailedForecastContainerOnScreen = mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return WeekWeatherFragmentOnView(
            imageContainerOnScreen[position],
            nameContainerOnScreen[position],
            temperatureContainerOnScreen[position],
            windSpeedContainerOnScreen[position],
            windDirectionContainerOnScreen[position],
            imageURLContainerOnScreen[position],
            shortForecastContainerOnScreen[position],
            detailedForecastContainerOnScreen[position],
            position
        )
    }

    override fun getCount(): Int = imageContainerOnScreen.size
}