package com.firuz.currencyconvertor.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firuz.currencyconvertor.data.local.entity.ExchangerEntity

@Dao
interface ExchangerDao {
    @Query("SELECT bank_name, short_name, icon FROM exchanger")
    fun getExchanger(): LiveData<List<ExchangerEntity>>

    @Query("SELECT name, full_name, flag, sell_value, buy_value FROM exchanger")
    fun getCurrencyForExchanger()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateExchanger(exchanger: List<ExchangerEntity>)

}