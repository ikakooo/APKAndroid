package com.example.week3recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.items_scrollviewitems_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:ItemsConstructorUseAdapter
private val items = mutableListOf<ItemsClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        starButtonClick()
    }

    private fun init(){
        adapter =  ItemsConstructorUseAdapter(items)
        scrollViewItems.layoutManager = LinearLayoutManager(this)
        scrollViewItems.adapter =adapter

         addDate()

    }
    private fun addDate(){
        items.add(ItemsClass(R.mipmap.learnandroid,"ikakooo's post","You can Become developer","you stered item"))
        items.add(ItemsClass(R.mipmap.hack,"ikakooo's post","Choose the best hack tools","you stered item"))
        items.add(ItemsClass(R.mipmap.second,"ikakooo's post","dense with me","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.hack,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.learnandroid,"ikakooo's post","You can Become developer","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.second,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.learnandroid,"ikakooo's post","You can Become developer","you stered item"))
        items.add(ItemsClass(R.mipmap.hack,"ikakooo's post","Choose the best hack tools","you stered item"))
        items.add(ItemsClass(R.mipmap.second,"ikakooo's post","dense with me","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.hack,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.learnandroid,"ikakooo's post","You can Become developer","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.second,"ikakooo's post","Nature Art","you stered item"))
        items.add(ItemsClass(R.mipmap.tree,"ikakooo's post","Nature Art","you stered item"))

    }
    fun starButtonClick(){
        //itemImageButton.setOnClickListener {
             Toast.makeText(this@MainActivity, "you can star items", Toast.LENGTH_LONG).show()
       //}
    }

}
