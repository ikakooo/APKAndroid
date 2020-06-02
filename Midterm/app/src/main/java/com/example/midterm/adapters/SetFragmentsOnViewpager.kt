package com.example.midterm.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.midterm.fragments.WeekWeatherFragmentOnView

class SetFragmentsOnViewpager(fm : FragmentManager, behavior:Int):
    FragmentStatePagerAdapter(fm,behavior) {

    var imageconteiner= mutableListOf<Int>()

    override fun getItem(position: Int): Fragment {
        return   WeekWeatherFragmentOnView(imageconteiner[position],position)
    }

    override fun getCount(): Int =imageconteiner.size
}