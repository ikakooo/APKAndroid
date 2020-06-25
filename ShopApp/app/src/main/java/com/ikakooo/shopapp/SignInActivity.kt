package com.ikakooo.shopapp

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log.d
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




        rememberCheckButtonID.setOnClickListener {
            if (REMEMBER_ME) {
                rememberCheckButtonID.setCompoundDrawablesWithIntrinsicBounds(
                    R.mipmap.unchecked,
                    0,
                    0,
                    0
                )
                REMEMBER_ME = false
            } else {
                rememberCheckButtonID.setCompoundDrawablesWithIntrinsicBounds(
                    R.mipmap.cheked,
                    0,
                    0,
                    0
                )
                REMEMBER_ME = true
            }

            d("sdfsdfsdfsdf", REMEMBER_ME.toString())
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


}


