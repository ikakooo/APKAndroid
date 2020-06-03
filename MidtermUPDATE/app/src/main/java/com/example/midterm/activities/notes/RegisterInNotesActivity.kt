package com.example.midterm.activities.notes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register_in_notes.*

class RegisterInNotesActivity : AppCompatActivity() {
    private  val MIN_PASS_CHARARACTER_LENGS = 8
    private val TOAST_LENGth = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_in_notes)
        init()

    }
    @SuppressLint("WrongConstant")
    private fun init(){
        RegisterButtonID.setOnClickListener(){
            val email = EmailRegisterActivityEditTextsID.text.toString()
            val password = PasswordRegisterActivityEditTextsID.text.toString()
            val rePassword = ReenteredPasswordRegisterActivityEditTextsID.text.toString()
            fun isEmailValid(email: String): Boolean {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }

            if ((password == rePassword)&&(password.length >= MIN_PASS_CHARARACTER_LENGS)){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) {
                            Toast.makeText(this, "This Email does already exist", Toast.LENGTH_LONG).show()
                            return@addOnCompleteListener
                        }else{
                            //d("jjksdfhd","ikakooo: ${it.result?.user?.uid}")
                            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show()
                            Handler().postDelayed({
                                finish()
                            },2000)
                        }

                    }
            }else if (!isEmailValid(email)){
                Toast.makeText(this, "Please input correct Email", Toast.LENGTH_LONG).show()
            }else if ((password.length <= MIN_PASS_CHARARACTER_LENGS)&&(rePassword.length <= MIN_PASS_CHARARACTER_LENGS)){
                Toast.makeText(this, "Short password, input between 8-64", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Reentered Password doesn't match", Toast.LENGTH_LONG).show()
            }




        }
        backToLogInTextViewID.setOnClickListener (){
            finish()
        }





    }





}