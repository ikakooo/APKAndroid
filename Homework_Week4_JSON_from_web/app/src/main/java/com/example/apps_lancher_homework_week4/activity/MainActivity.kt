package com.example.apps_lancher_homework_week4.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log.d
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.models.Users
import com.example.apps_lancher_homework_week4.adapters.RecyclerViewAdapter
import com.example.apps_lancher_homework_week4.api.TestRetrofitHTTP
import com.example.apps_lancher_homework_week4.interfacesBox.httpToJSON
import com.example.apps_lancher_homework_week4.models.AppsModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.*
import org.json.JSONObject
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter

    private val applications = mutableListOf<AppsModels>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        toast()


    }



    fun httpRequestJS(){
//        httpToJSON.enqueue(object: Callback<String> {
//            override fun onResponse(message: String) {
//                d("hhh",message)
//            }
//
//            override fun onFailure(value: String) {
//                d("failure","failure")
//            }
//
//        })

    }


    private fun init() {
        adapter = RecyclerViewAdapter(applications)
        scrollViewItems.layoutManager = GridLayoutManager(this, 1)
        scrollViewItems.adapter = adapter
        readJSON()
       // applications.add(Users(R.mipmap.fb, "Facebook","იკაკოო","i_chkhitunidze@cu.edu.ge","refjeijerijkferif"))
        //addDate()
        swipeRefreshID.setOnRefreshListener {

            swipeRefreshID.isRefreshing = false
           // clearApps()



            Handler().postDelayed({
                swipeRefreshID.isRefreshing = false
                httpRequestJS()

                adapter.notifyDataSetChanged()
            },3000)

        }
    }


    @SuppressLint("CheckResult")
    private fun readJSON(){
        val json = JSONObject(json)
        val data =json.getJSONArray("data")
        val users = Users()
        users.page = json.getInt("page")
        users.perPage = json.getInt("per_page")
        users.total = json.getInt("total")
        users.totalPage = json.getInt("total_pages")
        for (i in 0 until data.length()){
            val readingData = data.getJSONObject(i)
           //val addingDate = Users.Date()
//            addingDate.ID = readingData.getInt("id")
//            addingDate.firstName = readingData.getString("first_name")
//            addingDate.lastName = readingData.getString("last_name")
//            addingDate.Email = readingData.getString("email")
//            addingDate.avatar = readingData.getString("avatar")
         // Glide.with(this).load(readingData.getString("avatar")).into(imageButtonID)
            applications.add(AppsModels(readingData.getInt("id"), readingData.getString("first_name"), readingData.getString("last_name"),readingData.getString("email"),readingData.getString("avatar")))


        }



    }

    var json = "{\n" +
            "    \"page\": 2,\n" +
            "    \"per_page\": 6,\n" +
            "    \"total\": 12,\n" +
            "    \"total_pages\": 2,\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"id\": 7,\n" +
            "            \"email\": \"michael.lawson@reqres.in\",\n" +
            "            \"first_name\": \"Michael\",\n" +
            "            \"last_name\": \"Lawson\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 8,\n" +
            "            \"email\": \"lindsay.ferguson@reqres.in\",\n" +
            "            \"first_name\": \"Lindsay\",\n" +
            "            \"last_name\": \"Ferguson\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 9,\n" +
            "            \"email\": \"tobias.funke@reqres.in\",\n" +
            "            \"first_name\": \"Tobias\",\n" +
            "            \"last_name\": \"Funke\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 10,\n" +
            "            \"email\": \"byron.fields@reqres.in\",\n" +
            "            \"first_name\": \"Byron\",\n" +
            "            \"last_name\": \"Fields\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 11,\n" +
            "            \"email\": \"george.edwards@reqres.in\",\n" +
            "            \"first_name\": \"George\",\n" +
            "            \"last_name\": \"Edwards\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 12,\n" +
            "            \"email\": \"rachel.howell@reqres.in\",\n" +
            "            \"first_name\": \"Rachel\",\n" +
            "            \"last_name\": \"Howell\",\n" +
            "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"ad\": {\n" +
            "        \"company\": \"StatusCode Weekly\",\n" +
            "        \"url\": \"http://statuscode.org/\",\n" +
            "        \"text\": \"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"\n" +
            "    }\n" +
            "}"




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
