package com.example.apps_lancher_homework_week4.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.databinding.AppsScrollviewitemsLayoutBinding

import com.example.apps_lancher_homework_week4.models.AppsModels
import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.*

import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.view.*


class RecyclerViewAdapter(private val applications: MutableList<AppsModels>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

//    companion object {
//        const val CONTEXT_ITEMS = 1
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder{
            val binding: AppsScrollviewitemsLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
               R.layout.apps_scrollviewitems_layout, parent, false
    )
        return ViewHolder(binding)
    }


    override fun getItemCount() = applications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()

    }

    inner class ViewHolder(val binding: AppsScrollviewitemsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var appinit: AppsModels
        fun onBind() {
            appinit = applications[adapterPosition]
            //binding.applications = applications[adapterPosition]
            binding.applications.firstName = appinit.firstName
            binding.applications.lastName = appinit.lastName
            binding.applications.Email = appinit.Email

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