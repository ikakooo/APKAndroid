package com.example.quiz4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_main_a_layout.view.*

class RecyclerviewAdapter(private val items: MutableList<ItemsModel>) :  RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_main_a_layout, parent, false)
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
        private lateinit var modelinit: ItemsModel
        //        fun removeDate(){
//            itemView.taskBarButtonDelete4.setOnClickListener(){
//                items.removeAt(adapterPosition)
//                notifyDataSetChanged()
//            }
//           // var positionForDelete = adapterPosition
//        }
        fun onBind() {
            modelinit = items[adapterPosition]
//            itemView.imageView.setImageResource(modelinit.image)
//            itemView.textView.text = modelinit.poster
//            itemView.textView2.text = modelinit.description
           itemView.itemImageButton.setOnClickListener(){
               changeXto0()
           }

        }
        private fun changeXto0(){

            var x = 1
            x++

            if(x/2==1){
                itemView.itemImageButton.setImageResource(modelinit.image1)
            }else{
                itemView.itemImageButton.setImageResource(modelinit.image2)
            }
        }


        //fun(){ Toast.makeText(this@items_scrollviewitems_layout, "ikakooo stared item", Toast.LENGTH_SHORT).show()}

    }
}