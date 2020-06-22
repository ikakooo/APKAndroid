package com.example.week9_geolocation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week9_geolocation.R
import com.example.week9_geolocation.models.adapters_models.SearchResultAdapter_Model
import kotlinx.android.synthetic.main.address_recycler_view_layout.view.*
import kotlinx.android.synthetic.main.countries_recycler_view_layout.view.*

class RecyclerViewAdapter(private val items: MutableList<SearchResultAdapter_Model>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var selectedAddress =0
    var selectedAddressString = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.address_recycler_view_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: SearchResultAdapter_Model


        fun onBind() {
            item = items[adapterPosition]
            Log.d("sdkjfsdjfsdfsdssdfd", items.size.toString())
            itemView.locationTitleTextView.text = item.description.toString()
            //itemView.locationTitleTextView.text = item.predictions[adapterPosition].description.toString()


            if(adapterPosition==selectedAddress) {itemView.saveIconAddressID.visibility=View.VISIBLE
                selectedAddressString = item.description.toString()

            }
            else itemView.saveIconAddressID.visibility=View.INVISIBLE

            itemView.locationTitleTextView.setOnClickListener(){
                selectedAddress=adapterPosition
                notifyDataSetChanged()
            }

        }
    }
}