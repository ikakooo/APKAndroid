package com.example.apk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(View.OnClickListener {
            button.text = "გაიღიმე"
        })
        button.setBackgroundColor(Color.GREEN)
        button.setTextColor(Color.RED)
        constraintLayout.addView(button);

          val b:Bolean  =  randnums()
           if (b){
               Toast.makeText(this, "სასაცილოა", Toast.LENGTH_SHORT).show()

           }else {
               Toast.makeText(this, "მოსაბეზრებელია", Toast.LENGTH_SHORT).show()
           }

         }
     fun rundnums():Bolean {
         val randomNumber: int =(1..101).random()
         return randomNumber%2==0
     }

    }
}
