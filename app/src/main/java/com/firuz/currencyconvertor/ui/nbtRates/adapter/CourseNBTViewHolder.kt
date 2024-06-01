package com.firuz.currencyconvertor.ui.nbtRates.adapter

import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.data.remote.models.Currency
import com.firuz.currencyconvertor.databinding.CardNbtRateConverterBinding
import com.firuz.currencyconvertor.domain.models.NbtRate
import com.firuz.currencyconvertor.ui.loadRoundedImageWithCache
import com.firuz.currencyconvertor.ui.toFormattedMoney

class CourseNBTViewHolder(private val binding: CardNbtRateConverterBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(item: NbtRate, listener: (NbtRate) -> Unit){

        with(binding){
            root.setOnClickListener{
                listener(item)
            }
        }
         binding.flagImage.loadRoundedImageWithCache(item.flag)

            binding.courseName.text = item.name
            binding.courseNameRu.text = item.fullName
            binding.courseSumma.text = (item.value / item.nominal).toFormattedMoney()
    }
}