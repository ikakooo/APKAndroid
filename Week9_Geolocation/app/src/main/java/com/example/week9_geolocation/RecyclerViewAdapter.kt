package com.example.week9_geolocation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week9_geolocation.models.LocationJSonModel
import kotlinx.android.synthetic.main.address_recycler_view_layout.view.*

class RecyclerViewAdapter(private val items: MutableList<LocationJSonModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.address_recycler_view_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: LocationJSonModel

        fun onBind() {
            item = items[adapterPosition]
            itemView.locationTitleTextView.text = item.predictions[adapterPosition].description.toString()
        }
    }
}