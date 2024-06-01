package com.firuz.currencyconvertor.data.remote.models

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nominal")
    val nominal: Double,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("value")
    val value: Double
)