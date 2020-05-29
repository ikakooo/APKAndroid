package com.example.apps_lancher_homework_week4.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apps_lancher_homework_week4.R
import kotlinx.android.synthetic.main.activity_add_person.*
import kotlinx.android.synthetic.main.activity_main.*

class AddPersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
        init()
    }





    fun init(){
        saveItemButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java).apply {
                // putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }}
}