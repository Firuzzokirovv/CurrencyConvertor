package com.firuz.currencyconvertor.data.remote

import com.firuz.currencyconvertor.data.remote.models.Currency
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://appsmile.ru/api/academy/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val CurrencyRateApiService = retrofit.create(com.firuz.currencyconvertor.data.remote.api.CurrencyRateApiService::class.java)
        fun getNbtRate(): Call<List<Currency>> = CurrencyRateApiService.getNbtRates()

        fun getExchanger(): Call<List<Exchanger>> = CurrencyRateApiService.getExchanger()


}