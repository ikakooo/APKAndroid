package com.example.week6viewpager.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.week6viewpager.R
import com.example.week6viewpager.adapters.MyCustomPagerAdapter
//import com.example.week6viewpager.adapters.MyCustomPagerAdapter
import com.example.week6viewpager.fragments.FirstBlankFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var add =0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val viewPager = viewpagerID as ViewPager
//        viewPager.adapter = MyCustomPagerAdapter(this)

//        Handler().postDelayed({
//        }, 2000)
        init()
        supportFragmentManager.beginTransaction().replace(R.id.myContainerID,FirstBlankFragment()).commit()
    }



    @SuppressLint("SetTextI18n")
    private fun init(){
        val imageContainer= mutableListOf<Int>()
        val imageContainerOnScreen = mutableListOf<Int>()
        imageContainerOnScreen.add(R.drawable.ic_launcher_background)
        imageContainer.add(R.mipmap.bacground)
        imageContainer.add(R.mipmap.fb)
        imageContainer.add(R.mipmap.free)
        imageContainer.add(R.mipmap.instagram)
        imageContainer.add(R.mipmap.itunes_logo)
        imageContainer.add(R.mipmap.learnandroid)
        imageContainer.add(R.mipmap.logo)
        imageContainer.add(R.mipmap.second)
        imageContainer.add(R.mipmap.tesla)
        imageContainer.add(R.mipmap.tree)



        val adapter = MyCustomPagerAdapter(supportFragmentManager,count)
        adapter.imageconteiner = imageContainerOnScreen
        viewpagerID.adapter = adapter

        addButtonID.setOnClickListener(){
            textViewID.text ="Photos : "+ (count+2).toString()
            imageContainerOnScreen.add(imageContainer[add])
            adapter.notifyDataSetChanged()
            add++
            count++
            if(add==imageContainer.size){
                add =0
            }
        }
        addFromWebButtonID.setOnClickListener(){
            textViewID.text ="Photos : "+ (count+2).toString()
        }

    }

}
