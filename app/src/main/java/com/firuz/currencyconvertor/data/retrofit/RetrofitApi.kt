package com.firuz.currencyconvertor.data.retrofit

import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.model.Exchanger
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://appsmile.ru/api/academy/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val CurrencyRateApiService = retrofit.create(com.firuz.currencyconvertor.data.api.CurrencyRateApiService::class.java)
        fun getCourseNBT(): Call<List<Currency>> = CurrencyRateApiService.getCourseNBT()

        fun getExchanger(): Call<List<Exchanger>> = CurrencyRateApiService.getExchanger()


}