package com.example.week6useingfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager

import com.example.week6useingfragment.R

class LogInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         changeInfoFragmentToFragment()
        return inflater.inflate(R.layout.fragment_log_in, container, false)

    }

    private fun  changeInfoFragmentToFragment(){
//        val bundle = Bundle()
//        bundle.putString("key", "Jhon Doe") // set your parameteres
//
//
//        val nextFragment = LoggedInFragment()
//        nextFragment.arguments = bundle
//
//        val fragmentManager: FragmentManager = getActivity().getSupportFragmentManager()
//        fragmentManager.beginTransaction().replace(R.id.LoggedInFragment, nextFragment).commit()
//        // loggedInTextViewID.text = infoFromLogIn
    }
}
