package com.firuz.currencyconvertor.ui.exchanger

import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.firuz.currencyconvertor.data.model.Exchanger
import com.firuz.currencyconvertor.data.retrofit.RetrofitApi
import com.firuz.currencyconvertor.ui.exchanger.adapter.ExchangerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExchangerViewModel : ViewModel() {
    var isLoading: Boolean = false
    var errorMessage: String? = null
    var dataSet: List<Exchanger> = emptyList()

    fun loadRates(
        onLoading: (isLoading: Boolean) -> Unit,
        onError: (message: String?) -> Unit,
        onSuccess: (dataSet: List<Exchanger>) -> Unit
    ){
        isLoading = true
        onLoading(isLoading)

        RetrofitApi.getExchanger().enqueue(object : Callback<List<Exchanger>> {
            override fun onResponse(
                p0: Call<List<Exchanger>>,
                p1: Response<List<Exchanger>>
            ) {

                isLoading = false
                onLoading(isLoading)

                    if (p1.isSuccessful) {
                        errorMessage = null
                        dataSet = p1.body() ?: emptyList()
                        onSuccess(dataSet)
                    } else {
                        errorMessage = "Что-то пошло не так"
                        onError(errorMessage)
                    }
                }

            override fun onFailure(
                p0: Call<List<Exchanger>>,
                p1: Throwable
            ) {

                errorMessage = "Что-то пошло не так"
                onError(errorMessage)

            }
        })


    }

}