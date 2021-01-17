package me.sanchez.androidApp

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}
