package com.example.week5_http_status_codes_hendling.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week5_http_status_codes_hendling.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        buttonMainAcID.setOnClickListener(){
            check()


        }
    }

    private fun check(){
        val email = emailEditTextView.text.toString()
        val password = passwordEditTextView.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty() ){

            goToLoggedInAct()
        }else{

            toast()
        }
    }


    private fun goToLoggedInAct(){
        startActivity(Intent(this,IdentifiedUsersActivity::class.java))
        finish()

    }

    private fun toast(){
        val toast = Toast.makeText(applicationContext, "ორივე ველის შევსება სავალდებულოა!", Toast.LENGTH_SHORT)
        toast.show()
    }
}
