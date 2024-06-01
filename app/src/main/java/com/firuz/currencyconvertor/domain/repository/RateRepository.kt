package com.firuz.currencyconvertor.domain.repository

import androidx.lifecycle.LiveData
import com.firuz.currencyconvertor.domain.models.NbtRate

interface RateRepository {
    fun getNbtRate(): LiveData<List<NbtRate>>
}