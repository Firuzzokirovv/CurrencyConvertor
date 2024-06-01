package com.firuz.currencyconvertor.ui.nbtRates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firuz.currencyconvertor.data.mapper.NbtRateItemMapper
import com.firuz.currencyconvertor.data.mapper.NbtRateMapper
import com.firuz.currencyconvertor.data.repository.RatesRepositoryImpl
import com.firuz.currencyconvertor.domain.repository.RateRepository
import com.firuz.currencyconvertor.ui.App

class NbtViewModelProviderFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repository: RateRepository = RatesRepositoryImpl(
            apiService = App.currencyRateApiService,
            nbtDao = App.nbtDao,
            nbtRateMapper = NbtRateMapper(),
            nbtRateItemMapper = NbtRateItemMapper()
        )

        return NBTRateViewModel(repository) as T
    }
}