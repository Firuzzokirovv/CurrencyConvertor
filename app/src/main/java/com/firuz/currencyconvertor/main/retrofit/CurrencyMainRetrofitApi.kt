package com.firuz.currencyconvertor.main.retrofit

import com.firuz.currencyconvertor.main.model.CoursesNBTApiService
import com.firuz.currencyconvertor.main.model.Results
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyMainRetrofitApi {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://transfer.humo.tj/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val CoursesNBTApiService = retrofit.create(CoursesNBTApiService::class.java)
        fun getCourseNBT(): Call<Results> = CoursesNBTApiService.getCourseNBT()

}