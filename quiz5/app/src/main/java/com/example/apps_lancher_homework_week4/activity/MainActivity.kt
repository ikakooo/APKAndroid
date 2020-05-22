package com.example.apps_lancher_homework_week4.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log.d
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.models.Users
import com.example.apps_lancher_homework_week4.adapters.RecyclerViewAdapter
import com.example.apps_lancher_homework_week4.api.HttpRequestForGettingBands
import com.example.apps_lancher_homework_week4.models.Bands
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*

import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter

    private val applications = mutableListOf<Bands>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Handler().postDelayed({
            toast()
            init()
        }, 2000)
    }

    private fun init() {
        adapter = RecyclerViewAdapter(applications)
        scrollViewItems.layoutManager = GridLayoutManager(this, 2)
        scrollViewItems.adapter = adapter
        //readJSON()
        readJSONBand()

        adapter.notifyDataSetChanged()
    }


    @SuppressLint("CheckResult")
    private fun readJSON(){


    }
    private fun readJSONBand(){
       var info = Gson().fromJson(jsonVariables, Array<Bands>::class.java)
        applications.add(Bands("sdhsj", "img_url", "img_url","img_url","img_url","img_url","img_url"))
        //d("ikakoo", jsonVariables)
    }
    val postsApi = HttpRequestForGettingBands().myRetrofit.create(HttpRequestForGettingBands.RetrofitCalls::class.java)

    val jsonVariables = postsApi.findPosts().execute().body().toString()






//    private fun clearApps(){
//        applications.clear()
//       adapter.notifyDataSetChanged()
//    }


//    private fun addDate() {
//        applications.add(AppsModels(R.mipmap.fb, "Facebook"))
//        applications.add(AppsModels(R.mipmap.instagram, "instagram"))
//        applications.add(AppsModels(R.mipmap.itunes_logo, "ITunes"))
//        applications.add(AppsModels(R.mipmap.logo, "skype"))
//        applications.add(AppsModels(R.mipmap.tesla, "Tesla"))
//        applications.add(AppsModels(R.mipmap.ic_launcher, "TestApp"))
//    }

     private fun toast() {
         Toast.makeText(this@MainActivity, "Swipe down and show more users", Toast.LENGTH_LONG).show()
     }


//    private fun searchApp(){
//        applications.add(AppsModels(0,"Tesla"))
//    }
}
