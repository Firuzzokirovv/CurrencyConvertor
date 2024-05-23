package com.firuz.currencyconvertor.ui.exchanger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firuz.currencyconvertor.data.model.Exchanger
import com.firuz.currencyconvertor.data.retrofit.RetrofitApi
import com.firuz.currencyconvertor.databinding.ExchangerFragmentBinding
import com.firuz.currencyconvertor.ui.exchanger.adapter.ExchangerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExchangerFragment : Fragment() {
    private var _binding: ExchangerFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExchangerFragmentBinding.inflate(layoutInflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadNbtRates()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadNbtRates() {

        binding.progressBar.isVisible = true
        binding.errorPanel.isVisible = false
        binding.errorPanel.isVisible = false

        RetrofitApi.getExchanger().enqueue(object : Callback<List<Exchanger>> {
            override fun onResponse(p0: Call<List<Exchanger>>, p1: Response<List<Exchanger>>) {
                if (this@ExchangerFragment.isAdded) {
                    binding.progressBar.isVisible = false

                    if (p1.isSuccessful) {
                        binding.recyclerViewExchanger.adapter =
                            ExchangerAdapter(itemData = p1.body() ?: emptyList())
                        binding.recyclerViewExchanger.isVisible = true

                    } else {
                        binding.errorPanel.isVisible = true
                        binding.textViewErrorMessage.text = "Что-то пошло не так"
                    }
                }
            }

            override fun onFailure(p0: Call<List<Exchanger>>, p1: Throwable) {
                if (this@ExchangerFragment.isAdded){
                    binding.progressBar.isVisible = false
                    binding.recyclerViewExchanger.isVisible = false
                    binding.errorPanel.isVisible = true
                    binding.textViewErrorMessage.text = p1.message
                }
            }
        })
    }

}