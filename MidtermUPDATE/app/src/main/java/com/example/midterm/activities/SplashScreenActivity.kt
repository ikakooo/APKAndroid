package com.example.midterm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.midterm.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        moveMainActivity()
    }





    private fun moveMainActivity(){
        Handler().postDelayed({
            startActivity(Intent(this, WeatherActivity::class.java))
            finish()
        },2000)
    }
}








