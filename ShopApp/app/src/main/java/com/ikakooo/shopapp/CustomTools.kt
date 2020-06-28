package com.ikakooo.shopapp

import android.app.Dialog
import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.my_custom_dialog_layout.*

object CustomTools {
    fun customDialog(context: Context, title: String, description: String){
        val dialog = Dialog(context)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.my_custom_dialog_layout)


        val params: WindowManager.LayoutParams = dialog.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = params
        dialog.customDialogTitleID.text = title
        dialog.customDialogDescriptionsID.text = description
        dialog.customDialogDoneButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



     fun setColor(view: TextView, color: Int, text: String,context: Context) {
        // val builder = SpannableStringBuilder()


        val string: Spannable = SpannableString(text)
        string.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, color)),
            0,
            string.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        view.append(string)


        //view.setText(builder, TextView.BufferType.SPANNABLE)

    }

}