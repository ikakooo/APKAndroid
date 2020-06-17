package com.example.week9_geolocation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week9_geolocation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init(){
        floating_action_button.setOnClickListener {
            val intent = Intent(this, AddressesSearchActivity::class.java)
            startActivity(intent)
        }

    }
}