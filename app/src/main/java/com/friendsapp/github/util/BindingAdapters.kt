package com.friendsapp.github.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

/**
 * to load image url with Glide library
 */
@BindingAdapter("imageUrl")

fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(url).into(view)
    }
}

@BindingAdapter("dateFormatter")
fun TextView.dateFormatter(string: String?) {
    if (string?.isNotEmpty() == true) {
        val date = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(string)
        date?.let {
            val format = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
            this.text = format.format(it)
        }

    }

}