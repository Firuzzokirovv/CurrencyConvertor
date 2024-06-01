package com.firuz.currencyconvertor.data.remote.api

import com.firuz.currencyconvertor.data.remote.models.Currency
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyRateApiService {
    @GET("data.json")
    fun getNbtRates(): Call<List<Currency>>

    @GET("npcr_bank_rates_data.json")
    fun getExchanger(): Call<List<Exchanger>>

}
