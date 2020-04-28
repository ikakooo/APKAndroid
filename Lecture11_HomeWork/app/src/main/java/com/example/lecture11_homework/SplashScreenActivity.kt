package com.example.lecture11_homework

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        ttt()
    }


    private fun ttt() {

        Handler().postDelayed({
            startActivity(Intent(this, EdditPersonalInfoActivity::class.java))
            finish()
        }, 4000)
    }


}
