package com.firuz.currencyconvertor.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.currencyconvertor.databinding.CardItemCourseNbtBinding
import com.firuz.currencyconvertor.main.model.CourseNBT

class CurrencyMainAdapter(private val itemData: List<CourseNBT>) :
    RecyclerView.Adapter<CurrencyMainAdapter.CourseNBTViewHolder>() {

    class CourseNBTViewHolder(val binding: CardItemCourseNbtBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseNBTViewHolder {
        val binding =
            CardItemCourseNbtBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CourseNBTViewHolder(binding)
    }

    override fun getItemCount(): Int = itemData.size

    override fun onBindViewHolder(holder: CourseNBTViewHolder, position: Int) {
        val item = itemData[position]
        val binding = holder.binding

        Glide.with(holder.binding.root)
            .load(item.flag)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.flagImage)

        binding.courseName.text = item.name
        binding.courseNameRu.text = item.fullName
        binding.courseSumma.text = String.format("%.6f", item.value.toDouble())

    }
}