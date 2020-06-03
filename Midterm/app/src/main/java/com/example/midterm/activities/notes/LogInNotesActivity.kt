package com.example.midterm.activities.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in_notes.*
import kotlinx.android.synthetic.main.activity_register_in_notes.*

class LogInNotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_notes)
        init()
        // Initialize Firebase Auth

    }


    private fun init() {
        LogInButtonID.setOnClickListener() {
            val email = LogInEmailEditTextsID.text.toString()
            val password = LogInPasswordEditTextsID.text.toString()
            if (email.length >= 5 && password.length >= 8) {
                Toast.makeText(
                    this,
                    "please wait! before Email and Password checking",
                    Toast.LENGTH_LONG
                ).show()
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Password or Email doesn't match",
                                Toast.LENGTH_LONG
                            ).show()
                            //return@addOnCompleteListener
                        } else {
                            startActivity(Intent(this, LoggedInNotesActivity::class.java))
                            finish()
                        }

                    }
            }else{Toast.makeText(
                this,
                "Password or Email doesn't match",
                Toast.LENGTH_LONG
            ).show()}
//                .addOnFailureListener {
//                    Toast.makeText(this, "Password or Email doesn't match", Toast.LENGTH_LONG).show()
//                }
        }
        RegisterTextViewID.setOnClickListener() {
            startActivity(Intent(this, RegisterInNotesActivity::class.java))
        }
    }


}