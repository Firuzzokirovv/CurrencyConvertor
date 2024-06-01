package com.firuz.currencyconvertor.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.firuz.currencyconvertor.data.local.dao.NbtDao
import com.firuz.currencyconvertor.data.mapper.NbtRateItemMapper
import com.firuz.currencyconvertor.data.mapper.NbtRateMapper
import com.firuz.currencyconvertor.data.remote.api.CurrencyRateApiService
import com.firuz.currencyconvertor.data.remote.models.Currency
import com.firuz.currencyconvertor.domain.models.NbtRate
import com.firuz.currencyconvertor.domain.repository.RateRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class RatesRepositoryImpl(
    private val apiService: CurrencyRateApiService,
    private val nbtDao: NbtDao,
    private val nbtRateMapper: NbtRateMapper,
    private val nbtRateItemMapper: NbtRateItemMapper
) : RateRepository {
    override fun getNbtRate(): LiveData<List<NbtRate>> {
        updateDataFromMapper()
        return nbtDao.getNBTRates().map {
            it.map { item -> NbtRateMapper().map(item) }
        }
    }

    private fun updateDataFromMapper() {
        apiService.getNbtRates().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(
                p0: Call<List<Currency>>, p1: Response<List<Currency>>
            ) {

                if (p1.isSuccessful) {
                    val list = p1.body() ?: emptyList()
                    nbtDao.updateNBTRate(list.map { item -> nbtRateItemMapper.map(item) })
                }
            }

            override fun onFailure(p0: Call<List<Currency>>, p1: Throwable) {
                // TODO
            }

        })
    }
}