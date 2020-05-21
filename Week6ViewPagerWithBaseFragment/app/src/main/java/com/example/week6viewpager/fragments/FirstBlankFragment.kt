package com.example.week6viewpager.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.week6viewpager.R
import kotlinx.android.synthetic.main.fragment_first_blank.*
import kotlinx.android.synthetic.main.fragment_first_blank.view.*


class FirstBlankFragment : BaseFragment() {


    override fun inputLayoutResource(): Int {
        return R.layout.fragment_first_blank
    }

    @SuppressLint("SetTextI18n")
    override fun mainLogicFunctions(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        Handler().postDelayed({
            buttonFirstFragmentID.setOnClickListener(){
                MainItemsView!!.textViewFirstFragmentID.text = "ikakooo"
            }
                }, 2000)

    }

//    @SuppressLint("SetTextI18n")
//    override fun mainLogicFunctions() {
//        buttonFirstFragmentID.setOnClickListener(){
//            MainItemsView!!.textViewFirstFragmentID.text = "ikakooo"
//        }
//    }


}
