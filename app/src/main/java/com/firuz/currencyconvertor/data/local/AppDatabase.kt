package com.firuz.currencyconvertor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.firuz.currencyconvertor.data.local.dao.ExchangerDao
import com.firuz.currencyconvertor.data.local.dao.NbtDao
import com.firuz.currencyconvertor.data.local.entity.NbtRateEntity

@Database(entities = [NbtRateEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nbtDao(): NbtDao
    abstract fun exchangerDao(): ExchangerDao
}