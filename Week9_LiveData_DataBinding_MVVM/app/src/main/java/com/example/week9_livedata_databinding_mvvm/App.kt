package com.example.week9_livedata_databinding_mvvm

import android.app.Application
import android.content.Context


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    companion object {
        lateinit var mInstance: App
        fun getContext(): Context? {
            return mInstance.applicationContext
        }
    }
}