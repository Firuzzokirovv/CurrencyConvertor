package com.firuz.currencyconvertor.ui.exchanger.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.databinding.CardExchangerBinding

class ExchangerViewHolder(private val binding: CardExchangerBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(item: Currency, listener: (Currency) -> Unit){

        with(binding){
            root.setOnClickListener{
                listener(item)
            }
        }

        Glide.with(binding.root)
            .load(item.flag)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .circleCrop()
            .placeholder(R.drawable.flag_empty)
            .error(R.drawable.flag_error)
            .into(binding.titleImageView)

        binding.titleBank.text = item.name
        /*binding.courseNameRu.text = item.fullName
        binding.courseSumma.text = String.format("%.6f",item.value / item.nominal) + "c."*/
    }

}