package com.ikakooo.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    private val SplashThread = object : Thread() {
        override fun run() {
            try {
                Thread.sleep(2000)
                val intent = Intent(baseContext, SignInActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        SplashThread
    }


    override fun onResume() {
        super.onResume()
        SplashThread.start()
    }


    override fun onPause() {
        super.onPause()
        SplashThread.interrupt()
        d("sdfdfsdfs", SplashThread.isAlive.toString())

    }

}