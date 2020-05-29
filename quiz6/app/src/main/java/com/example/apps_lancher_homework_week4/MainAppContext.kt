package com.example.apps_lancher_homework_week4

import android.app.Application
import android.content.Context

class MainAppContext : Application() {

    init {
        instance = this
    }

    companion object {
        var instance: MainAppContext? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = MainAppContext.applicationContext()
    }
}