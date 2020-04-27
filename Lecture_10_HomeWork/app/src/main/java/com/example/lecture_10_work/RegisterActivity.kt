package com.example.lecture_10_work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }
   private fun init(){
        chooseAddressButton.setOnClickListener(){
            SecondActivity()
            var value1 = userNikTextView.text.toString()
            var value2 = firstNameTextView.text.toString()
            var value3 = lastNameTextView.text.toString()
            var value4 = ageTextView.text.toString()
        }
        signUpButton.setOnClickListener(){
            ChoosAddres()

       }

    }
    private fun SecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

    }
    private fun ChoosAddres(){
        val intent = Intent(this, AuthorizedUserActivity::class.java)
        startActivity(intent)
       // var value1 = firstNameTextView.text.toString()
       // intent.putExtra("user",userNikTextView.text.toString())
    }
}
