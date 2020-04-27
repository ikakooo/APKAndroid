package com.example.lecture_10_work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.acthivity_autorized_user.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_second.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AuthorizedUserActivity : AppCompatActivity() {
    //val intent = getIntent()


    //ttth =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acthivity_autorized_user)
        init()
    }


    private fun init(){
      //  val user: String = intent.getStringExtra("user")
       // authorizedUserTextView.text = user.toString()


    }


}
