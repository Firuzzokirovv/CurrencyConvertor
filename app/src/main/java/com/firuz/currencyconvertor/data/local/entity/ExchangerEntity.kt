package com.firuz.currencyconvertor.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchanger")
data class ExchangerEntity(
    @PrimaryKey @ColumnInfo("bank_name") val bankName: String,
    @ColumnInfo("short_name") val shortName: String,
    @ColumnInfo("icon") val icon: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("full_name") val fullName: String,
    @ColumnInfo("flag") val flag: String,
    @ColumnInfo("sell_value") val sellValue: Double,
    @ColumnInfo("buy_value") val buyValue: Double
)

