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
        val data =json.getJSONArray("competitions")
        (0 until data.length()).forEach{
            val area = data.getJSONObject(it).getJSONObject("area")
            applications.add(AppsModels(area.getInt("id"), area.getString("name"), area.getString("countryCode"),area.getString("ensignUrl")))
        }
//        val users = Users()
//        users.page = json.getInt("page")
//        users.perPage = json.getInt("per_page")
//        users.total = json.getInt("total")
//        users.totalPage = json.getInt("total_pages")
//        for (i in 0 until data.length()){
//            val readingData = data.getJSONObject(i)
//           //val addingDate = Users.Date()
////            addingDate.ID = readingData.getInt("id")
////            addingDate.firstName = readingData.getString("first_name")
////            addingDate.lastName = readingData.getString("last_name")
////            addingDate.Email = readingData.getString("email")
////            addingDate.avatar = readingData.getString("avatar")
//         // Glide.with(this).load(readingData.getString("avatar")).into(imageButtonID)
          //  applications.add(AppsModels(readingData.getInt("id"), readingData.getString("first_name"), readingData.getString("last_name"),readingData.getString("email"),readingData.getString("avatar")))


      //  }



    }

    var json = "{\n" +
            "    \"count\": 149,\n" +
            "    \"filters\": {},\n" +
            "    \"competitions\": [\n" +
            "        {\n" +
            "            \"id\": 2006,\n" +
            "            \"area\": {\n" +
            "                \"id\": 2001,\n" +
            "                \"name\": \"Africa\",\n" +
            "                \"countryCode\": \"AFR\",\n" +
            "                \"ensignUrl\": null\n" +
            "            },\n" +
            "            \"name\": \"WC Qualification\",\n" +
            "            \"code\": null,\n" +
            "            \"emblemUrl\": null,\n" +
            "            \"plan\": \"TIER_FOUR\",\n" +
            "            \"currentSeason\": {\n" +
            "                \"id\": 555,\n" +
            "                \"startDate\": \"2019-09-04\",\n" +
            "                \"endDate\": \"2021-11-16\",\n" +
            "                \"currentMatchday\": null,\n" +
            "                \"winner\": null\n" +
            "            },\n" +
            "            \"numberOfAvailableSeasons\": 2,\n" +
            "            \"lastUpdated\": \"2018-06-04T23:54:04Z\"\n" +
            "        }, }\n" +
            "    ]\n" +
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
