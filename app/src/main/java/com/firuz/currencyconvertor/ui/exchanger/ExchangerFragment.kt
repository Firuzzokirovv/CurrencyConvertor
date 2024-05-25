package com.firuz.currencyconvertor.ui.exchanger

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.currencyconvertor.R
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
    private val viewModel: ExchangerViewModel by viewModels()
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

        setLoading(viewModel.isLoading)
        setError(viewModel.errorMessage)

        if (viewModel.dataSet.isEmpty()){
            viewModel.loadRates(
                onError = ::setError,
                onLoading = ::setLoading,
                onSuccess = ::setupRecyclerView
            )
        } else {
            setupRecyclerView(viewModel.dataSet)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    private fun setError(message: String?){
        binding.errorPanel.isVisible = !message.isNullOrEmpty()
        binding.textViewErrorMessage.text = message
    }

    private fun setupRecyclerView(dataSet: List<Exchanger>){
        binding.recyclerViewExchanger.isVisible = true
        binding.recyclerViewExchanger.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewExchanger.adapter = ExchangerAdapter(dataSet){
            val action =
                ExchangerFragmentDirections.actionNavExchangerToNavConverter(
                    title = it.bankName
                )
            findNavController().navigate(action)
        }
    }

}