package com.firuz.currencyconvertor.ui.exchanger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.model.Exchanger
import com.firuz.currencyconvertor.databinding.CardExchangerBinding
import com.firuz.currencyconvertor.ui.nbtRates.adapter.CourseNBTViewHolder

class ExchangerAdapter(
    private val itemData: List<Exchanger>) :
    RecyclerView.Adapter<ExchangerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangerViewHolder {
        val binding =
            CardExchangerBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ExchangerViewHolder(binding)
    }

    override fun getItemCount(): Int = itemData.size

    override fun onBindViewHolder(holder: ExchangerViewHolder, position: Int) {
        holder.bind(itemData[position])




    }
}