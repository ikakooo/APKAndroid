package com.example.week5_http_status_codes_hendling.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_http_status_codes_hendling.R
import com.example.week5_http_status_codes_hendling.models.ItemsClass
import kotlinx.android.synthetic.main.layout_identifyed_recyclerview.view.*

class DataModelAdapter(private val items: MutableList<ItemsClass>) :  RecyclerView.Adapter<DataModelAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_identifyed_recyclerview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
        //holder.starButtonClick()
        //holder.removeDate()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var modelinit: ItemsClass
        //        fun removeDate(){
//            itemView.taskBarButtonDelete4.setOnClickListener(){
//                items.removeAt(adapterPosition)
//                notifyDataSetChanged()
//            }
//           // var positionForDelete = adapterPosition
//        }
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



        //fun(){ Toast.makeText(this@items_scrollviewitems_layout, "ikakooo stared item", Toast.LENGTH_SHORT).show()}

    }
}