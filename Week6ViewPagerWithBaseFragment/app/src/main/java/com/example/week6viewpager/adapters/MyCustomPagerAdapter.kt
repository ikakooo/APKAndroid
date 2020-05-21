package com.example.week6viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.week6viewpager.fragments.HomeBlankFragment


class MyCustomPagerAdapter(fm : FragmentManager, behavior:Int):
    FragmentStatePagerAdapter(fm,behavior) {

    var imageconteiner= mutableListOf<Int>()

    override fun getItem(position: Int): Fragment {
        return   HomeBlankFragment(imageconteiner[position],position)
    }

    override fun getCount(): Int =imageconteiner.size
}