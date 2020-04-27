package com.example.lecture_10_work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init(){
        firsPageButton.setOnClickListener(){
            ChoosAddres()
        }

    }


    private fun ChoosAddres(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
