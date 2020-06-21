package com.example.week9_geolocation.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log.d
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.week9_geolocation.CustomTools
import com.example.week9_geolocation.R
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        init()
        setSupportActionBar(toolbarID)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        ToolbarTextViewID.text = getString(R.string.Address)

    }

    override fun onResume() {
        super.onResume()
        getInputValues()
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun init() {
//        CountryEditTextId.setOnClickListener {
//
//                val intent = Intent(this, AddressesSearchActivity::class.java)
//                startActivity(intent)
//        }

        CountryEditTextId.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    startActivity(intent(1))
                }
            }
            v?.onTouchEvent(event) ?: true
        }

        addressEditTextID.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    startActivity(intent(2))
                }
            }
            v?.onTouchEvent(event) ?: true
        }


        floating_action_button.setOnClickListener {
            customDialogIfFieldsIsEmpty()
        }

    }


    private fun customDialogIfFieldsIsEmpty() {
        CustomTools.customDialog(
            this,
            getString(R.string.incorrect_request),
            getString(R.string.please_fill_all_fields)
        )
    }

    private fun intent(ACTIVITI_CODE: Int) = when (ACTIVITI_CODE) {

        1 -> Intent(this, ChooseCountryActivity::class.java)
        2 -> Intent(this, AddressesSearchActivity::class.java)

        else ->  Intent(this, AddressesSearchActivity::class.java)
    }


    private fun getInputValues(){

        var strUser: String? = intent.extras?.getString("Username","GE")

        //val selected=intent.extras?.getString("SelectedCountryAbbreviation")
        d("sdfsdfsdsds",strUser.toString())
          if (strUser != null) {

              CountryEditTextId.text = Editable.Factory.getInstance().newEditable(strUser)
          }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK){

            var strUsers= data?.extras?.getString("Username","GE")


            CountryEditTextId.text = Editable.Factory.getInstance().newEditable(strUsers)

        }
    }

}