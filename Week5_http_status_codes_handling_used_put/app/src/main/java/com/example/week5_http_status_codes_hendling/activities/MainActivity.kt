package com.example.week5_http_status_codes_hendling.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import com.example.week5_http_status_codes_hendling.R
import com.example.week5_http_status_codes_hendling.api.HttpsRequest
import com.example.week5_http_status_codes_hendling.api.MyCallback
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        buttonMainAcID.setOnClickListener(){
            //check()

            goToLoggedInAct()
        }
    }


    private fun check(){
        val email = emailEditTextView.text.toString()
        val password = passwordEditTextView.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty() ){
            val mapOFF = mutableMapOf<String,String>()
            mapOFF["email"]= email
            mapOFF["password"]= password
              d("fixit", email)
            HttpsRequest.postRequest("login", mapOFF, object : MyCallback {
                    override fun onFailure(error: String) {
                         d("reg", error)
                    }

                    override fun onResponse(response: String) {
                       // goToLoggedInAct()
                    }

                }
            )
            goToLoggedInAct()
        }else{

            toast()
        }
    }

    private fun readAPI(){

    }


    private fun goToLoggedInAct(){
        startActivity(Intent(this,IdentifiedUsersActivity::class.java))
        finish()

    }

    private fun toast(){
        val toast = Toast.makeText(applicationContext, "ორივე ველის შევსება სავალდებულოა!", Toast.LENGTH_SHORT)
        toast.show()
    }
}
