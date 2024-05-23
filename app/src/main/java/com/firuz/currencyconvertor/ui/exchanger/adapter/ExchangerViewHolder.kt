package com.firuz.currencyconvertor.ui.exchanger.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.data.model.Exchanger
import com.firuz.currencyconvertor.databinding.CardExchangerBinding

class ExchangerViewHolder(private val binding: CardExchangerBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(item: Exchanger){

        Glide.with(binding.root)
            .load(item.icon)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .circleCrop()
            .placeholder(R.drawable.flag_empty)
            .error(R.drawable.flag_error)
            .into(binding.titleImageView)

        binding.titleBank.text = item.bankName
    }

}