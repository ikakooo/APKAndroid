package com.example.week6useingfragment.activities

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.week6useingfragment.R
import com.example.week6useingfragment.fragments.ButtonsFragment
import com.example.week6useingfragment.fragments.LogInFragment
import com.example.week6useingfragment.fragments.LoggedInFragment
import kotlinx.android.synthetic.main.fragment_buttons.*
import kotlinx.android.synthetic.main.fragment_log_in.*


class MainActivity : AppCompatActivity() {
    var infoFromLogIn:String = "out"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        Handler().postDelayed({
            openLogoutValue()
            openLogInValue()

        }, 2000)


    }

    private fun init() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragmentButtons = ButtonsFragment()
        val fragmentInput = LogInFragment()
        transaction.replace(R.id.buttonsBar, fragmentButtons, "ButtonsBar")
        transaction.replace(R.id.inputValues, fragmentInput)
        transaction.addToBackStack("ButtonsBar")
        transaction.commit()

        //openLogInValue()
    }


    private fun openLogInValue() {
        logInUserButton.setOnClickListener() {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = LoggedInFragment()
            transaction.replace(R.id.inputValues, fragment)
            transaction.addToBackStack("ButtonsBar")
            transaction.commit()
           infoFromLogIn = emailEditTextView.text.toString()
              // changeInfoFragmentToFragment()
        }
    }

    private fun openLogoutValue() {
        logOutUserButton.setOnClickListener() {
            val transaction = supportFragmentManager.beginTransaction()
            val fragmentInput = LogInFragment()
            transaction.replace(R.id.inputValues, fragmentInput)
            transaction.addToBackStack("ButtonsBar")
            transaction.commit()
        }
    }


}
