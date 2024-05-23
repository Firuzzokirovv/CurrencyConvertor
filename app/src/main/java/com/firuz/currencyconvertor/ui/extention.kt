package com.firuz.currencyconvertor.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.R

fun ImageView.loadRoundedImageWithCache(url: String){
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .circleCrop()
        .placeholder(R.drawable.flag_empty)
        .error(R.drawable.flag_error)
        .into(this)
}

fun Double.toFormattedMoney(): String = String.format("%.6f", this) + " c."
