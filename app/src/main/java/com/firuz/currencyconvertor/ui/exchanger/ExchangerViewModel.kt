package com.firuz.currencyconvertor.ui.exchanger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import com.firuz.currencyconvertor.data.remote.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExchangerViewModel : ViewModel() {

    private val _uiStateMutable: MutableLiveData<ExchangerUIState> =
        MutableLiveData(ExchangerUIState())
    val uiState: LiveData<ExchangerUIState> get() = _uiStateMutable

    init {
        loadRates()
    }

    fun reload() {
        loadRates()
    }

    private fun loadRates() {
        _uiStateMutable.value = _uiStateMutable.value?.copy(
            isLoading = true,
            errorMessage = null
        )

        RetrofitApi.getExchanger().enqueue(object : Callback<List<Exchanger>> {
            override fun onResponse(
                p0: Call<List<Exchanger>>,
                p1: Response<List<Exchanger>>
            ) {
                    if (p1.isSuccessful) {
                        _uiStateMutable.value = _uiStateMutable.value?.copy(
                            isLoading = false,
                            errorMessage = null,
                            dataSet = p1.body() ?: emptyList()
                        )

                    } else {
                        _uiStateMutable.value = _uiStateMutable.value?.copy(
                            isLoading = false,
                            errorMessage = "Что-то пошло не так"
                        )
                    }
                }

            override fun onFailure(
                p0: Call<List<Exchanger>>,
                p1: Throwable
            ) {
                _uiStateMutable.value = _uiStateMutable.value?.copy(
                    isLoading = false,
                    errorMessage = p1.message
                )
            }
        })


    }

}

data class ExchangerUIState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val dataSet: List<Exchanger> = emptyList()
)