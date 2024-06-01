package com.firuz.currencyconvertor.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nbt_rate")
data class NbtRateEntity(
    @PrimaryKey @ColumnInfo("name") val name: String,
    @ColumnInfo("nominal") val nominal: Double,
    @ColumnInfo("full_name") val fullName: String,
    @ColumnInfo("flag") val flag: String,
    @ColumnInfo("value") val value: Double
)
