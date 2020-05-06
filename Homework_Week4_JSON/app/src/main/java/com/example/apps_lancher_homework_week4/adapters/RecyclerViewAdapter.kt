package com.example.apps_lancher_homework_week4.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apps_lancher_homework_week4.R
import com.example.apps_lancher_homework_week4.models.AppsModels
import com.example.apps_lancher_homework_week4.models.Users
import kotlinx.android.synthetic.main.apps_scrollviewitems_layout.view.*


class RecyclerViewAdapter(private val applications: MutableList<Users>) :
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
        private lateinit var appinit: Users

        fun onBind() {
            appinit = applications[adapterPosition]
            //itemView.imageButtonID.setImageResource(appinit.image)
            itemView.firstNameTextView.text = appinit.firstName
            itemView.lastNameTextView.text = appinit.lastName
            itemView.firstNameTextView.text = appinit.Email
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