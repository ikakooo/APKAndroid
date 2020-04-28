package com.example.lecture11_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eddit_personal_info.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

class EdditPersonalInfoActivity : AppCompatActivity() {

    var editRight = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eddit_personal_info)
        init()
        disableEditText()
    }


    private fun init(){
        editInfoButton.setOnClickListener(){
            editRight = true
            disableEditText()

        }


    }
    private fun disableEditText() {
        userNikTextView.isEnabled = editRight
        userNikTextView.isFocusable = editRight
        userNikTextView.isFocusableInTouchMode = editRight

        firstNameTextView.isEnabled = editRight
        firstNameTextView.isFocusable = editRight
        firstNameTextView.isFocusableInTouchMode = editRight

        lastNameTextView.isEnabled = editRight
        lastNameTextView.isFocusable = editRight
        lastNameTextView.isFocusableInTouchMode = editRight

        ageTextView.isEnabled = editRight
        ageTextView.isFocusable = editRight
        ageTextView.isFocusableInTouchMode = editRight

        genderTextView.isEnabled = editRight
        genderTextView.isFocusable = editRight
        genderTextView.isFocusableInTouchMode = editRight
    }
}
