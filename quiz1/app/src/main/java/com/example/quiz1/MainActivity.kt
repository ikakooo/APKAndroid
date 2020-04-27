package com.example.quiz1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    

    private var userCount = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

                setContentView(R.layout.activity_main)
        addUser()
        // removeUser()
    }

    @SuppressLint("SetTextI18n")
    private fun addUser() {
        eddUserButton.setOnClickListener {

            val userNameSaver = usernameText.text.toString()
            val ageIntSaver = ageInt.text.toString()
            val emailTextSaver = emailText.text.toString()
            val firstNameSaver = firsNameText.text.toString()

            textViewShow.text =
                "$userCount ) First Name: $firstNameSaver Last Name: $userNameSaver Age: $ageIntSaver Email: $emailTextSaver"
            // textViewShow.text = "ikakooo  $firstNameSaver"
            userCount++
        }


    }

    //private fun removeUser(){
    //   removeUserButton.setOnClickListener{


    //   }

    // }


}
