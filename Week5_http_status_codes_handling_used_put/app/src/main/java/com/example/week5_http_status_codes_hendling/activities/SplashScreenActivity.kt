package com.example.week5_http_status_codes_hendling.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.week5_http_status_codes_hendling.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        moveMainActivity()

    }



    private fun moveMainActivity(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },4000)
    }
}
