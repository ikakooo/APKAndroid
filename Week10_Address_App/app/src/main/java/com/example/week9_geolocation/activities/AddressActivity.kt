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
    private var countryID : String? = "GE"
    companion object {
        const val CHOOSE_COUNTRY = 1
        const val CHOOSE_ADDRESS = 2
    }

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
        //getInputValues()
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
                    startActivityForResult(intent(1),CHOOSE_COUNTRY)
                }
            }
            v?.onTouchEvent(event) ?: true
        }

        addressEditTextID.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    val myIntent = Intent(this, AddressesSearchActivity::class.java)
                    myIntent.putExtra("countryID", countryID)
                    startActivityForResult(myIntent,CHOOSE_ADDRESS)
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

        val intent = intent;
        val myValue = intent.getStringExtra("samplename")

        //val selected=intent.extras?.getString("SelectedCountryAbbreviation")
        d("sdfsdfsdsds",myValue.toString())
          if (myValue != null) {

              CountryEditTextId.text = Editable.Factory.getInstance().newEditable(myValue.toString())
          }else{
              CountryEditTextId.text = Editable.Factory.getInstance().newEditable("Georgia")
          }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CHOOSE_COUNTRY) {
                val myValue:String?  = data?.extras?.getString("samplename").toString()
                 countryID  = data?.extras?.getString("samplenameID").toString()
                CountryEditTextId.text = Editable.Factory.getInstance().newEditable(myValue)

            }else if (requestCode == CHOOSE_ADDRESS){
                val myValueAddress:String?  = data?.extras?.getString("addressExtraString").toString()


                addressEditTextID.text = Editable.Factory.getInstance().newEditable(myValueAddress)
            }
        }
    }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(resultCode== Activity.RESULT_OK){
//
//            var strUsers= data!!.extras!!.getString("Username","GE")
//
//
//            CountryEditTextId.text = Editable.Factory.getInstance().newEditable(strUsers)
//
//        }
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == CHOOSE_COUNTRY) {
//
//                   // data!!.extras!!.getString("countryId", ""),
//                d("sdfsdfsdsds",data!!.extras!!.getString("countryName", "GE"))
//                CountryEditTextId.text = Editable.Factory.getInstance().newEditable(data!!.extras!!.getString("countryName", "GE"))
//
//            } else if (requestCode == CHOOSE_STREET_ADDRESS) {
//                return
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

}