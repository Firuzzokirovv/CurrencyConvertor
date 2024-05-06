package com.firuz.currencyconvertor.data.api

import com.firuz.currencyconvertor.data.model.Currency
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface CoursesNBTApiService {
    @GET("currency-app/v1/nbt_rates")
    fun getCourseNBT(): Call<List<Currency>>

}
