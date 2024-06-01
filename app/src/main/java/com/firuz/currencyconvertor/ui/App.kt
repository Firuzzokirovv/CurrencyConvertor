package com.firuz.currencyconvertor.ui

import android.app.Application
import androidx.room.Room
import com.firuz.currencyconvertor.data.local.AppDatabase
import com.firuz.currencyconvertor.data.local.dao.NbtDao
import com.firuz.currencyconvertor.data.remote.api.CurrencyRateApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://appsmile.ru/api/academy/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        currencyRateApiService = retrofit.create(CurrencyRateApiService::class.java)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "currency-database"
        )
            .allowMainThreadQueries()
            .build()

        nbtDao = db.nbtDao()

    }

    companion object {
        lateinit var instance: App
        lateinit var currencyRateApiService: CurrencyRateApiService
        lateinit var nbtDao: NbtDao
    }
}
