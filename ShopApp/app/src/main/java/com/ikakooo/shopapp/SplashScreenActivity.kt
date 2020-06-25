package com.ikakooo.shopapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


    var runnable= Runnable {
        init()
    }
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //SplashThread.start()
    }


    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,2000)
    }


    override fun onPause() {
        super.onPause()
        //SplashThread.interrupt()
        d("sdfdfsdfs", SplashThread.isAlive.toString())
        handler.removeCallbacks(runnable)
    }


    private fun init(){
        val intent=Intent(this,SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }

}