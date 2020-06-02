package com.example.midterm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    var MainItemsView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (MainItemsView == null) {
            MainItemsView = inflater.inflate(inputLayoutResource(), container, false)
            mainLogicFunctions(inflater, container, savedInstanceState)
        }
        return MainItemsView
    }
    abstract fun mainLogicFunctions(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )

    abstract fun inputLayoutResource(): Int

}