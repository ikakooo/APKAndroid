package com.example.week6viewpager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.week6viewpager.R
import kotlinx.android.synthetic.main.fragment_home_blank.view.*

class HomeBlankFragment(var img: Int,var position:Int) : Fragment() {
    lateinit var itemView:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        itemView =inflater.inflate(R.layout.fragment_home_blank, container, false)
        addimg()
        return itemView
    }
private  fun addimg(){
    itemView.imageButtonID.setImageResource(img)
    itemView.textViewOnPhotoID.text = (position+1).toString()
}

}
