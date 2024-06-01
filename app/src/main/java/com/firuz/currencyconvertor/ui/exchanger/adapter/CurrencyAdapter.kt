package com.firuz.currencyconvertor.ui.exchanger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import com.firuz.currencyconvertor.databinding.CardCurrencyBinding
import com.firuz.currencyconvertor.ui.exchanger.adapter.CurrencyAdapter.CurrencyViewHolder.Companion.VIEW_TYPE
import com.firuz.currencyconvertor.ui.loadRoundedImageWithCache
import com.firuz.currencyconvertor.ui.toFormattedMoney

class CurrencyAdapter(
    private val itemData: List<Exchanger.Currencies>,
    private val listener: (item: Exchanger.Currencies) -> Unit
) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding =
            CardCurrencyBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }

    override fun getItemCount(): Int = itemData.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(itemData[position], listener)
    }
    class CurrencyViewHolder(private val binding: CardCurrencyBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: Exchanger.Currencies,
            listener: (item: Exchanger.Currencies) -> Unit
        ) {
            binding.root.setOnClickListener {
                listener(item)
            }

            binding.imageViewCurrencyIcon.loadRoundedImageWithCache(item.flag)

            binding.textViewCurrencyName.text = item.name

            binding.textViewBuy.text = item.buyValue.toFormattedMoney()
            binding.textViewSell.text = item.sellValue.toFormattedMoney()
        }
        companion object {
            const val VIEW_TYPE = 2
        }
    }
}