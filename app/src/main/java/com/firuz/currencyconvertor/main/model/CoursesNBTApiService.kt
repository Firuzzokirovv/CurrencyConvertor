package com.firuz.currencyconvertor.main.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface CoursesNBTApiService {
    @GET("currency-app/v1/nbt_rates")
    fun getCourseNBT(): Call<Results>

}

data class Results(
    @SerializedName("results")
    val results: List<CourseNBT>
)

data class CourseNBT(
    @SerializedName("name")
    val name: String,
    @SerializedName("nominal")
    val nominal: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("value")
    val value: Double
)
