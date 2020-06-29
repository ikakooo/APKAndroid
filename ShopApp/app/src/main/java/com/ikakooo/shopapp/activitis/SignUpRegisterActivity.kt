package com.ikakooo.shopapp.activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikakooo.shopapp.CustomTools
import com.ikakooo.shopapp.R
import kotlinx.android.synthetic.main.activity_sign_up_register.*


class SignUpRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_register)
        init()
        buttons()
    }



    private fun init(){
        CustomTools.setColor(signInTextViewID, (R.color.colorText), "Already a member?" + " ", this)
        CustomTools.setColor(signInTextViewID, (R.color.colorPrimary), " Log in", this)


    }

    private fun buttons(){
        singInButtonID.setOnClickListener(){
            val intent= Intent(this, CompleteProfileActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }

    }
}