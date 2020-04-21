package com.example.lecture6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun minus() {
        var number = textView.text.toString().toInt()
        if(number>0){number--

        textView.text = number.toString()}
    }

    private fun plus() {
        var number = textView.text.toString().toInt()
       if(number<10){ number++

        textView.text = number.toString()}
    }


    private fun init() {
        minusButton.setOnClickListener {
            minus()
        }

        plusButton.setOnClickListener {
            plus()
        }


    }
}
