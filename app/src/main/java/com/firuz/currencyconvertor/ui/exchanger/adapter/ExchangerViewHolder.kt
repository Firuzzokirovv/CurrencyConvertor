package com.firuz.currencyconvertor.ui.exchanger.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import com.firuz.currencyconvertor.databinding.CardExchangerBinding
import com.firuz.currencyconvertor.ui.loadRoundedImageWithCache
class ExchangerViewHolder(
    private val binding: CardExchangerBinding,
    private val viewPool: RecycledViewPool) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(
        item: Exchanger,
        listener: (item: Exchanger) -> Unit){

        with(binding){

            root.setOnClickListener {
                listener(item)
            }

            binding.titleImageView.loadRoundedImageWithCache(item.icon)
            binding.titleBank.text = item.bankName

            recyclerViewCurrency.setRecycledViewPool(viewPool)
            recyclerViewCurrency.adapter = CurrencyAdapter(item.currency){

            }
        }
    }
    companion object {
        const val VIEW_TYPE = 1
    }
}