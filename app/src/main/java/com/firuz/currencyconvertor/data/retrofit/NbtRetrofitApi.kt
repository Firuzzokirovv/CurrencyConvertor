package com.firuz.currencyconvertor.data.retrofit

import com.firuz.currencyconvertor.data.model.Currency
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NbtRetrofitApi {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://transfer.humo.tj/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val CoursesNBTApiService = retrofit.create(com.firuz.currencyconvertor.data.api.CoursesNBTApiService::class.java)
        fun getCourseNBT(): Call<List<Currency>> = CoursesNBTApiService.getCourseNBT()

}