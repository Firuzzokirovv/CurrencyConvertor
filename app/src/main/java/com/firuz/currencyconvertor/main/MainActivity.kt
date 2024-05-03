package com.firuz.currencyconvertor.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.currencyconvertor.databinding.LayoutActivityMainBinding
import com.firuz.currencyconvertor.main.adapter.CurrencyMainAdapter
import com.firuz.currencyconvertor.main.model.Results
import com.firuz.currencyconvertor.main.retrofit.CurrencyMainRetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.layoutManager = LinearLayoutManager(this)


        CurrencyMainRetrofitApi.getCourseNBT().enqueue(object : Callback<Results> {
            override fun onResponse(p0: Call<Results>, p1: Response<Results>) {

                if (p1.isSuccessful) {
                    val resultList = p1.body()?.results ?: emptyList()
                    binding.root.adapter = CurrencyMainAdapter(resultList)

                } else {
                    Log.d("TAG_TEST", "!isSuccessful: что то пошло не так")
                }
            }

            override fun onFailure(p0: Call<Results>, p1: Throwable) {
                Log.d("TAG_TEST", "onFailure: вообще что то пошло не так ${p1.message}")
            }
        })


    }

}


