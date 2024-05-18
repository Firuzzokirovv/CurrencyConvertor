package com.firuz.currencyconvertor.ui.nbtRates.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.databinding.CardNbtRateConverterBinding
import com.firuz.currencyconvertor.data.model.Currency

class NbtAdapter(
    private val itemData: List<Currency>,
    private var listener: (item: Currency) -> Unit ) :
    RecyclerView.Adapter<CourseNBTViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseNBTViewHolder {
        val binding =
            CardNbtRateConverterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CourseNBTViewHolder(binding)
    }

    override fun getItemCount(): Int = itemData.size

    override fun onBindViewHolder(holder: CourseNBTViewHolder, position: Int) {
        holder.bind(itemData[position], listener)




    }
}