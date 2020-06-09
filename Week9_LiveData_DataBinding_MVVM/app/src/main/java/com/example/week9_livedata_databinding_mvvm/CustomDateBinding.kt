package com.example.week9_livedata_databinding_mvvm

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("visibility")
fun View.setVisibility(visible: Boolean) {

   visibility = if (visible) View.VISIBLE else View.GONE
}
//მუღამს შევყევი :დდდდდდ
@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
