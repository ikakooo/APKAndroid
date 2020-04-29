package com.example.week3recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_scrollviewitems_layout.*
import kotlinx.android.synthetic.main.items_scrollviewitems_layout.view.*
import kotlinx.android.synthetic.main.items_scrollviewitems_layout.view.itemImageButton

class ItemsConstructorUseAdapter(private val items: MutableList<ItemsClass>) :
    RecyclerView.Adapter<ItemsConstructorUseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.items_scrollviewitems_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
        //holder.starButtonClick()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var modelinit: ItemsClass
        fun onBind() {
            modelinit = items[adapterPosition]
            itemView.imageView.setImageResource(modelinit.image)
            itemView.textView.text = modelinit.poster
            itemView.textView2.text = modelinit.description
            itemView.itemImageButton.setOnClickListener(){
             itemView.textView3.text  = modelinit.star
            }
        }
        //val modelini = items[position]
        // holder.itemView.imageView




    }

   //fun(){ Toast.makeText(this@items_scrollviewitems_layout, "ikakooo stared item", Toast.LENGTH_SHORT).show()}

}