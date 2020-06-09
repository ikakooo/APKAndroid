package com.example.week9_livedata_databinding_mvvm

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week9_livedata_databinding_mvvm.App.Companion.getContext


class MyCustomViewModel: ViewModel() {
    val progressBarVisible = MutableLiveData<Boolean>()
    val logInTextInfo = MutableLiveData<String>()
    val smile = MutableLiveData<Int>()

    fun logIn(email: String, password: String) {
        progressBarVisible.value = true

        Handler().postDelayed({
            progressBarVisible.value = false
            if (email.isNotEmpty() && password.isNotEmpty()) {
                smile.value = (R.mipmap.smile)
                logInTextInfo.value = "Logged in successfully"
                Toast.makeText(getContext(), "Logged in successfully", Toast.LENGTH_LONG).show()
            } else {
                smile.value = (R.mipmap.happylove)
                Toast.makeText(getContext(), "Filed log in", Toast.LENGTH_LONG).show()
                logInTextInfo.value = "Filed log in"
            }
        }, 5000)
    }


}