package com.example.week9_geolocation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    private fun init(){
        floating_action_button.setOnClickListener {
            if(CountryEditTextId.text.isNotEmpty()){
                val intent = Intent(this, AddressesSearchActivity::class.java)
                startActivity(intent)
            }else
            customDialogIfFieldsIsEmpty()


        }

    }



   private fun customDialogIfFieldsIsEmpty(){
        CustomTools.customDialog(this,
            getString(R.string.incorrect_request),
            getString(R.string.please_fill_all_fields))
    }


}