package com.example.breakingbadcharacters.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.breakingbadcharacters.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .apply(RequestOptions().error(R.drawable.breaking_bad_img)).into(view)
    }
}