package com.ikakooo.shopapp.activitis

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.*
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ikakooo.shopapp.CustomTools
import com.ikakooo.shopapp.CustomTools.setColor
import com.ikakooo.shopapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {
    private var REMEMBER_ME = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
        moreButtons()
    }
    private fun moreButtons(){
        signUpTextViewID.setOnClickListener(){
            val intent= Intent(this, SignUpRegisterActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }

    }


    private fun init() {


        setColor(signUpTextViewID, (R.color.colorText), getString(R.string.new_user) + " ",this)
        setColor(signUpTextViewID, (R.color.colorAccent), getString(
            R.string.sign_up
        ) + " ",this)
        setColor(signUpTextViewID, (R.color.colorText), getString(
            R.string.here
        ),this)

        emailEditTextID.addTextChangedListener(textWatcher)
        logIn()

        rememberCheckButtonID.setOnClickListener {
            if (REMEMBER_ME) {
                rememberCheckButtonID.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.unchecked, 0, 0, 0)
                REMEMBER_ME = false
            } else {
                rememberCheckButtonID.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.cheked, 0, 0, 0)
                REMEMBER_ME = true
            }
        }


    }



private fun setEmailSuccessMarkIfValid(input:String):Boolean{
    var drawablesIcon: Drawable? = null
    val valid = CustomTools.isEmailValid(input.toString())
    if (valid){ drawablesIcon = getDrawable(R.mipmap.baseline_check_circle_big)}
    emailEditTextID.setCompoundDrawablesWithIntrinsicBounds(null,null,drawablesIcon,null)

return valid
}


    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(inputText: Editable?) {
        }

        override fun beforeTextChanged(
            inputText: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(inputText: CharSequence?, start: Int, before: Int, count: Int) {
            setEmailSuccessMarkIfValid(inputText.toString())
        }

    }


   private  fun logIn(){

        singInButtonID.setOnClickListener {
            val ifValidTrue = setEmailSuccessMarkIfValid(emailEditTextID.text.toString())
            if(emailEditTextID.text.isNullOrEmpty()|| PasswordEditTextId.text.isNullOrEmpty()){
                CustomTools.customDialog(
                    this,
                    getString(R.string.empty_fields),
                    getString(R.string.please_fill_all_fields)
                )
            }else if (!ifValidTrue){
                //ffddfd
                CustomTools.customDialog(
                    this,
                    getString(R.string.invalid_email),
                    getString(R.string.please_check)
                )
            } else if (PasswordEditTextId.text.toString().length<7){

                CustomTools.customDialog(this,"","")
            }else{
                CustomTools.customDialog(
                    this,
                    "Short Password",
                    "Strong Password is Required!"
                )
            }

        }
    }
}


