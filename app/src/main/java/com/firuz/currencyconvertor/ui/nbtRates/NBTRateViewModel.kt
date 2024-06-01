package com.firuz.currencyconvertor.ui.nbtRates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.firuz.currencyconvertor.domain.models.NbtRate
import com.firuz.currencyconvertor.domain.repository.RateRepository

class NBTRateViewModel(
    private val repository: RateRepository
) : ViewModel() {

    private val _uiStateMutable: MutableLiveData<NbtUIState> = MutableLiveData(NbtUIState())
    val uiState: LiveData<NbtUIState> get() = _uiStateMutable

    private val observer = Observer<List<NbtRate>> {
        _uiStateMutable.value = _uiStateMutable.value?.copy(
            isLoading = false,
            errorMessage = null,
            dataSet = it
        )
    }


    init {
        load()
    }
    fun reload(){
        load()
    }

    fun load(){
        repository.getNbtRate().observeForever(observer)
    }

    override fun onCleared() {
        super.onCleared()
        repository.getNbtRate().removeObserver(observer)
    }
}

data class NbtUIState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val dataSet: List<NbtRate> = emptyList()
)