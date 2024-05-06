package com.firuz.currencyconvertor.ui.nbtRates

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.firuz.currencyconvertor.data.model.Currency
import com.firuz.currencyconvertor.data.retrofit.NbtRetrofitApi
import com.firuz.currencyconvertor.databinding.NbtFragmentBinding
import com.firuz.currencyconvertor.ui.nbtRates.adapter.NbtAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NBTFragment : Fragment() {

    private var _binding: NbtFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NbtFragmentBinding.inflate(layoutInflater, container, false)
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
        binding.contentPanel.isVisible = false
        binding.errorPanel.isVisible = false

        NbtRetrofitApi.getCourseNBT().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(p0: Call<List<Currency>>, p1: Response<List<Currency>>) {
                binding.progressBar.isVisible = false

                if (p1.isSuccessful) {
                    binding.recyclerView.adapter =
                        NbtAdapter(itemData = p1.body() ?: emptyList())
                    binding.contentPanel.isVisible = true

                }
                else {
                    binding.errorPanel.isVisible = true
                    binding.textViewErrorMessage.text = "Что-то пошло не так"
                }
            }

            override fun onFailure(p0: Call<List<Currency>>, p1: Throwable) {
                binding.progressBar.isVisible = false
                binding.contentPanel.isVisible = false
                binding.errorPanel.isVisible = true
                binding.textViewErrorMessage.text = p1.message
            }
        })
    }
}