package com.firuz.currencyconvertor.ui.exchanger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.model.Exchanger
import com.firuz.currencyconvertor.databinding.CardExchangerBinding
import com.firuz.currencyconvertor.ui.nbtRates.adapter.CourseNBTViewHolder

class ExchangerAdapter(
    private val itemData: List<Exchanger>,
    private val listener: (item: Exchanger) -> Unit) :
    RecyclerView.Adapter<ExchangerViewHolder>() {
        private val viewPool = RecyclerView.RecycledViewPool()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangerViewHolder {
        val binding =
            CardExchangerBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ExchangerViewHolder(binding, viewPool)
    }

    override fun getItemCount(): Int = itemData.size

    override fun getItemViewType(position: Int): Int {
        return ExchangerViewHolder.VIEW_TYPE
    }

    override fun onBindViewHolder(holder: ExchangerViewHolder, position: Int) {
        holder.bind(itemData[position],listener)




    }
}