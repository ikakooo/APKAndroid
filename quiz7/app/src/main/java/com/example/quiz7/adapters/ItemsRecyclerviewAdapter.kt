package com.example.quiz7.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz7.R
import com.example.quiz7.models.field.FieldsRecyclerviewModel
import com.example.quiz7.models.field.FieldsRecyclerviewModelItem
import kotlinx.android.synthetic.main.items_recycler_view_layout.view.*


class ItemsRecyclerviewAdapter(private val applications: MutableList<FieldsRecyclerviewModelItem>) :
    RecyclerView.Adapter<ItemsRecyclerviewAdapter.ViewHolder>() {

//    companion object {
//        const val CONTEXT_ITEMS = 1
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.items_recycler_view_layout, parent, false)
        )
    }


    override fun getItemCount() = applications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()

    }

    inner class ViewHolder(FieldsRecyclerviewModel: View) : RecyclerView.ViewHolder(FieldsRecyclerviewModel) {
        private lateinit var appinit: FieldsRecyclerviewModelItem
        fun onBind() {
            appinit = applications[adapterPosition]
            itemView.ItemEmailEditTextID.hint = appinit.hint.toString()
//            //itemView.imageButtonID.setImageResource(appinit.image)
//            itemView.firstNameTextView.text = appinit.Name
//            itemView.lastNameTextView.text = appinit.countryCode
            //  itemView.emailTextView.text = appinit.ensignUrl
//            Glide.with(itemView.context).load(appinit.avatar).into(itemView.imageButtonID)
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