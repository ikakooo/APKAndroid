package com.example.quiz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    private lateinit var adapter:ItemsConstructorUseAdapter
    private val items = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        init()

    }

    private fun init(){
        adapter =  ItemsConstructorUseAdapter(items)
        scrollViewItems.layoutManager = LinearLayoutManager(this)
        scrollViewItems.adapter =adapter
       // addDate()
        // addDate2()
      //  removeDate()
    }





}
