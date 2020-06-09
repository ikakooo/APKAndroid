package com.example.week9_livedata_databinding_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week9_livedata_databinding_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myModel = ViewModelProvider(this)[MyCustomViewModel::class.java]
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.loginDataBinding = myModel
        binding.lifecycleOwner = this
    }
}
