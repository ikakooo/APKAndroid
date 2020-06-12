package com.example.quiz7.adapters

import android.graphics.Color
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz7.R
import com.example.quiz7.models.RecyclerviewModel
import com.example.quiz7.models.ServerJSonModelSubList

import com.example.quiz7.models.field.FieldsRecyclerviewModel

import kotlinx.android.synthetic.main.filds_recycler_view_layout.view.*
import kotlinx.android.synthetic.main.items_recycler_view_layout.view.*

class FieldsRecyclerViewAdapter(private val fields: MutableList<RecyclerviewModel>) :
    RecyclerView.Adapter<FieldsRecyclerViewAdapter.ViewHolder>() {
   private lateinit var itemsRecyclerViewAdapter: ItemsRecyclerviewAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.filds_recycler_view_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return fields.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: RecyclerviewModel

        fun onBind() {
            item = fields[adapterPosition]
            //itemView.textViewIDRecycler.text = item.field_id.toString()
            itemView.EmailEditTextID.hint = item.hint.toString()
            itemView.EmailEditTextID.setTextColor(Color.YELLOW)
            itemView.EmailEditTextID.setHintTextColor(Color.GREEN)
                if(item.keyboard.toString() == "text"){
                    itemView.EmailEditTextID.inputType = InputType.TYPE_CLASS_TEXT}else{
                    itemView.EmailEditTextID.inputType = InputType.TYPE_CLASS_NUMBER
                }




//
//            itemView.ItemsRecyclerviewID.layoutManager = LinearLayoutManager(itemView.context)
//            itemsRecyclerViewAdapter = ItemsRecyclerviewAdapter(fields)
//            itemView.ItemsRecyclerviewID.adapter = itemsRecyclerViewAdapter

        }
    }
}