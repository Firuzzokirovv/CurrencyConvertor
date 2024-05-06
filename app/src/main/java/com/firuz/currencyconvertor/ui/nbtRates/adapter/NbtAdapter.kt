package com.firuz.currencyconvertor.ui.nbtRates.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firuz.currencyconvertor.databinding.CardNbtRateConverterBinding
import com.firuz.currencyconvertor.data.model.Currency

class NbtAdapter(private val itemData: List<Currency>) :
    RecyclerView.Adapter<CourseNBTViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseNBTViewHolder {
        val binding =
            CardNbtRateConverterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CourseNBTViewHolder(binding)
    }

    override fun getItemCount(): Int = itemData.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CourseNBTViewHolder, position: Int) {
        holder.bind(itemData[position])




    }
}