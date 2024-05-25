package com.firuz.currencyconvertor.data.model
import com.google.gson.annotations.SerializedName


data class Exchanger(
    @SerializedName("bank_name")
    val bankName: String,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("currency")
    val currency: List<Currencies>
) {
    data class Currencies(
        @SerializedName("name")
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("flag")
        val flag: String,
        @SerializedName("sell_value")
        val sellValue: Double,
        @SerializedName("buy_value")
        val buyValue: Double

    )
}