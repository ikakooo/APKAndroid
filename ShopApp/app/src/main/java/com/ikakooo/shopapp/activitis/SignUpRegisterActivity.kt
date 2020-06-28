package com.ikakooo.shopapp.activitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikakooo.shopapp.CustomTools
import com.ikakooo.shopapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up_register.*

class SignUpRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_register)
        init()
    }



    private fun init(){
        CustomTools.setColor(signInTextViewID, (R.color.colorText), "Already a member?" + " ", this)
        CustomTools.setColor(signInTextViewID, (R.color.colorPrimary), " Log in", this)


    }
}