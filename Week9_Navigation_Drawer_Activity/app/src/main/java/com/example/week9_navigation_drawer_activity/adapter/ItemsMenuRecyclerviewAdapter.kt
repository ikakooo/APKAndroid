package com.example.week9_navigation_drawer_activity.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week9_navigation_drawer_activity.ItemsMenuModel
import com.example.week9_navigation_drawer_activity.R
import kotlinx.android.synthetic.main.items_menu_scrollviewitems_layout.view.*


class ItemsMenuRecyclerviewAdapter(private val items: MutableList<ItemsMenuModel>) :
    RecyclerView.Adapter<ItemsMenuRecyclerviewAdapter.ViewHolder>() {
    private var row = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.items_menu_scrollviewitems_layout, parent, false)
        )
    }


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var modelinit: ItemsMenuModel
        fun onBind() {
            modelinit = items[adapterPosition]

            itemView.IconImageViewID.setImageResource(modelinit.icon)
            itemView.titleTextViewID.text = modelinit.title
            if (adapterPosition == row) {
                itemView.setBackgroundColor(Color.parseColor("#567845"))
                itemView.titleTextViewID.setTextColor(Color.parseColor("#ffffff"))
            } else {
                itemView.setBackgroundColor(Color.parseColor("#ffffff"))
                itemView.titleTextViewID.setTextColor(Color.parseColor("#000000"))
            }

            itemView.setOnClickListener() {
                row = adapterPosition

                notifyDataSetChanged()
            }


//                for (i in 0..items.size) {
//
//                }
//                notifyDataSetChanged()
//            }


        }

    }


}