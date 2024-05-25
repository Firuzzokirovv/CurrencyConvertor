package com.firuz.currencyconvertor.ui.nbtRates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.retrofit.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NBTRateViewModel : ViewModel() {

    private val _uiStateMutable: MutableLiveData<NbtUIState> = MutableLiveData(NbtUIState())
    val uiState: LiveData<NbtUIState> get() = _uiStateMutable


    init {
        loadRate()
    }
    fun reload(){
        loadRate()
    }

    private fun loadRate(){
        _uiStateMutable.value = _uiStateMutable.value?.copy(
            isLoading = true,
            errorMessage = null
        )
        RetrofitApi.getCourseNBT().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(
                p0: Call<List<Currency>>,
                p1: Response<List<Currency>>
            ){

                    if (p1.isSuccessful) {
                        _uiStateMutable.value = _uiStateMutable.value?.copy(
                            isLoading = false,
                            errorMessage = null,
                            dataSet = p1.body()?: emptyList()
                        )
                    } else {
                        _uiStateMutable.value = _uiStateMutable.value?.copy(
                            isLoading = false,
                            errorMessage = "Что-то пошло не так"
                        )
                    }
            }

            override fun onFailure(p0: Call<List<Currency>>, p1: Throwable) {

                _uiStateMutable.value = _uiStateMutable.value?.copy(
                    isLoading = false,
                    errorMessage = p1.message
                )

            }
        })
    }
}

data class NbtUIState(
    var isLoading: Boolean = false,
    var errorMessage: String? = null,
    var dataSet: List<Currency> = emptyList()
)