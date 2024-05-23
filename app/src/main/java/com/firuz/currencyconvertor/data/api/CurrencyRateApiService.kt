package com.firuz.currencyconvertor.data.api

import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.model.Exchanger
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyRateApiService {
    @GET("data.json")
    fun getCourseNBT(): Call<List<Currency>>

    @GET("npcr_bank_rates_data.json")
    fun getExchanger(): Call<List<Exchanger>>

}
