package com.ikakooo.shopapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.*
import android.text.style.ForegroundColorSpan
import android.util.Log.d
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {
    private var REMEMBER_ME = false
    private var IF_REMEMBER_ME_UNCHEKED = 0
    private var IF_REMEMBER_ME_CHEKED = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
    }


    private fun init() {


        setColor(signUpTextViewID, (R.color.colorText), getString(R.string.new_user) + " ")
        setColor(signUpTextViewID, (R.color.colorAccent), getString(R.string.sign_up) + " ")
        setColor(signUpTextViewID, (R.color.colorText), getString(R.string.here))

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


    private fun setColor(view: TextView, color: Int, text: String) {
        // val builder = SpannableStringBuilder()


        val string: Spannable = SpannableString(text)
        string.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, color)),
            0,
            string.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        view.append(string)


        //view.setText(builder, TextView.BufferType.SPANNABLE)

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
                CustomTools.customDialog(this,getString(R.string.empty_fields), getString(R.string.please_fill_all_fields))
            }else if (!ifValidTrue){
                //ffddfd
                CustomTools.customDialog(this,getString(R.string.invalid_email),getString(R.string.please_check))
            } else {
                CustomTools.customDialog(this, "Short Password","Strong Password is Required!")
            }

        }
    }
}


