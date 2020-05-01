package com.example.quiz2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.users_scrollview_layout.view.*
//import kotlinx.android.synthetic.main.users_scrollview_layout.view.itemImageButton

class ItemsConstructorUseAdapter(private val items: MutableList<User>) :
    RecyclerView.Adapter<ItemsConstructorUseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.users_scrollview_layout, parent, false)
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
        private lateinit var modelinit: User
        fun removeDate() {
            // itemView.taskBarButtonDelete4.setOnClickListener(){
            //    items.removeAt(adapterPosition)
            //   notifyDataSetChanged()
            //  }
            // var positionForDelete = adapterPosition
        }

        fun onBind() {
            modelinit = items[adapterPosition]
             itemView.firstNameEditText.text = modelinit.userFirstName

            // itemView.textView.text = modelinit.poster
            //itemView.textView2.text = modelinit.description

            itemView.editImageButton.setOnClickListener() {



            }
            itemView.deleteImageButton.setOnClickListener() {
                //   itemView.textView3.text  = modelinit.star
            }



            //fun(){ Toast.makeText(this@items_scrollviewitems_layout, "ikakooo stared item", Toast.LENGTH_SHORT).show()}

        }
    }}
