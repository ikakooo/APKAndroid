package com.example.lecture_10_work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        init()
    }
    private fun init(){
        firsPageButton.setOnClickListener(){
            SecondActivity()

        }

    }
    private fun SecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

    }
}
