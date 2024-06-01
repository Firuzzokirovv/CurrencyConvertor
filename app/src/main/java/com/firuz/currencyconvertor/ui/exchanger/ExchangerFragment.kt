package com.firuz.currencyconvertor.ui.exchanger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.currencyconvertor.data.remote.models.Exchanger
import com.firuz.currencyconvertor.databinding.ExchangerFragmentBinding
import com.firuz.currencyconvertor.ui.exchanger.adapter.ExchangerAdapter

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

        viewModel.uiState.observe(viewLifecycleOwner){
            setLoading(it.isLoading)
            setError(it.errorMessage)
            setupRecyclerView(it.dataSet)
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

        binding.reloadButton.setOnClickListener {
            viewModel.reload()
        }
    }

    private fun setupRecyclerView(dataSet: List<Exchanger>){
        binding.recyclerViewExchanger.isVisible = dataSet.isNotEmpty()
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