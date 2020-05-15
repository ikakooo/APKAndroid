package com.example.quiz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:RecyclerviewAdapter
    private val items = mutableListOf<ItemsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        columnButtonID.setOnClickListener() {
            val columns = EditTextViewID.text.toString().toInt()






        adapter =  RecyclerviewAdapter(items)
        scrollViewItems.layoutManager = GridLayoutManager(this,columns)
        scrollViewItems.adapter = adapter
        //addDate()
        // addDate2()
       // removeDate()
             for (i in 0 until columns){
                                //items.add(ItemsModel(R.mipmap.baseline_close_black_24,R.mipmap.baseline_exposure_zero_black_24))
                 for (j in 0 until columns){
                     items.add(ItemsModel(R.mipmap.baseline_close_black_24,R.mipmap.baseline_exposure_zero_black_24))
                 }
                            }
            //scrollViewItems.scrollToPosition(items.size - 1)
            adapter.notifyDataSetChanged()
            }
    }

}
