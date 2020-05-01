package com.example.quiz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    private lateinit var adapter:ItemsConstructorUseAdapter
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        init()

    }

    private fun init(){
        adapter =  ItemsConstructorUseAdapter(users)
        scrollViewItems.layoutManager = LinearLayoutManager(this)
        scrollViewItems.adapter =adapter
        addDate()
        // addDate2()
      //  removeDate()
    }
private fun addDate(){
        users.add(User("irakli","Chkhitunidze","i_chkhitunidze@cu.edu.ge"))
    }




}
