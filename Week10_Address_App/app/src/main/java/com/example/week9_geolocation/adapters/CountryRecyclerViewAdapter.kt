package com.example.week9_geolocation.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week9_geolocation.R
import com.example.week9_geolocation.models.adapters_models.SearchCountriesAdapterModel
import kotlinx.android.synthetic.main.countries_recycler_view_layout.view.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*


class CountryRecyclerViewAdapter(private val Countries: MutableList<SearchCountriesAdapterModel>) :
    RecyclerView.Adapter<CountryRecyclerViewAdapter.ViewHolder>() {

    var selectedCountry = 0
    var selectedCountryAbbreviation ="GE"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.countries_recycler_view_layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    override fun getItemCount(): Int = Countries.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var country: SearchCountriesAdapterModel


        @SuppressLint("SetTextI18n")
        fun onBind() {
            country = Countries[adapterPosition]

            itemView.countriesTextViewID.text =  country.iso2.toString() +":  "+ country.name.toString()
            if(adapterPosition==selectedCountry) {itemView.saveIconID.visibility=View.VISIBLE
                selectedCountryAbbreviation = country.iso2.toString()
                d("sdfjldfjsdfkj",selectedCountryAbbreviation)


            }
            else itemView.saveIconID.visibility=View.INVISIBLE

            itemView.countriesTextViewID.setOnClickListener(){
                selectedCountry=adapterPosition
                notifyDataSetChanged()
            }
        }
    }


}



