package com.firuz.currencyconvertor.ui.nbtRates.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.databinding.CardNbtRateConverterBinding

class CourseNBTViewHolder(private val binding: CardNbtRateConverterBinding) :
    RecyclerView.ViewHolder(binding.root){

    @SuppressLint("SetTextI18n")
    fun bind(item: Currency){
         Glide.with(binding.root)
                .load(item.flag)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(binding.flagImage)

            binding.courseName.text = item.name
            binding.courseNameRu.text = item.fullName
            binding.courseSumma.text = String.format("%.6f",item.value / item.nominal) + "c."
    }
}