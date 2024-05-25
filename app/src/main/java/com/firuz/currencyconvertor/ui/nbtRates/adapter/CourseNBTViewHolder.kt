package com.firuz.currencyconvertor.ui.nbtRates.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.databinding.CardNbtRateConverterBinding
import com.firuz.currencyconvertor.ui.loadRoundedImageWithCache

class CourseNBTViewHolder(private val binding: CardNbtRateConverterBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(item: Currency, listener: (Currency) -> Unit){

        with(binding){
            root.setOnClickListener{
                listener(item)
            }
        }

         binding.flagImage.loadRoundedImageWithCache(item.flag)

            binding.courseName.text = item.name
            binding.courseNameRu.text = item.fullName
            binding.courseSumma.text = String.format("%.6f",item.value / item.nominal) + "c."
    }
}