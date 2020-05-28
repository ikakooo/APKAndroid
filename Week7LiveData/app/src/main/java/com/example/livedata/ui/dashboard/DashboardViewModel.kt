package com.example.livedata.ui.dashboard

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
        var counter = 0
    private val _text = MutableLiveData<String>().apply {
        value = (10 + counter).toString()
        increaseClicked()
    }
    val text: LiveData<String> = _text


   fun increaseClicked(){

        counter++
    }
}