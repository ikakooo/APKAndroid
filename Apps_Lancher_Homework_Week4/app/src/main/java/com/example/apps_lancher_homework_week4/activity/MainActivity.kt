package com.example.apps_lancher_homework_week4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.adapters.RecyclerViewAdapter
import com.example.apps_lancher_homework_week4.models.AppsModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter

    private val applications = mutableListOf<AppsModels>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        toast()
    }


    private fun init() {
        adapter = RecyclerViewAdapter(applications)
        scrollViewItems.layoutManager = GridLayoutManager(this, 4)
        scrollViewItems.adapter = adapter
        addDate()
        swipeRefreshID.setOnRefreshListener {

        swipeRefreshID.isRefreshing = false
            clearApps()


            Handler().postDelayed({
                swipeRefreshID.isRefreshing = false
                addDate()
                adapter.notifyDataSetChanged()
            },3000)

        }
    }

   private fun clearApps(){
        applications.clear()
       adapter.notifyDataSetChanged()
    }


    private fun addDate() {
        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
        applications.add(AppsModels(R.mipmap.logo, "skype"))
        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))

    }

     private fun toast(){
         Toast.makeText(this@MainActivity, "You can lunch app from here", Toast.LENGTH_LONG).show()
     }
}
