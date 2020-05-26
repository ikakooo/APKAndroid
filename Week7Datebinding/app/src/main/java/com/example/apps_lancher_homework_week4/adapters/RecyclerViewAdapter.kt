package com.example.apps_lancher_homework_week4.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.models.AppsModels
import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.*

import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.view.*


class RecyclerViewAdapter(private val applications: MutableList<AppsModels>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

//    companion object {
//        const val CONTEXT_ITEMS = 1
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.apps_scrollviewitems_layout, parent, false)
        )


    override fun getItemCount() = applications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()

    }

    inner class ViewHolder(AppsModels: View) : RecyclerView.ViewHolder(AppsModels) {
        private lateinit var appinit: AppsModels
        fun onBind() {
            appinit = applications[adapterPosition]
            //itemView.imageButtonID.setImageResource(appinit.image)
           itemView.firstNameTextView.text = appinit.firstName
            itemView.lastNameTextView.text = appinit.lastName
            itemView.emailTextView.text = appinit.Email
            Glide.with(itemView.context).load(appinit.avatar).into(itemView.imageButtonID)
        }
    }

//    inner class SearchBarViewHolder(AppsModels: View) : RecyclerView.ViewHolder(AppsModels) {
//        private lateinit var appinit: AppsModels
//
//        fun searchBarOnBind() {
//            appinit = applications[adapterPosition]
//            itemView.textViewID.text = appinit.appName
//        }
//    }

}