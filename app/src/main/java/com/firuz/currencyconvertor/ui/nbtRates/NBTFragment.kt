package com.firuz.currencyconvertor.ui.nbtRates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.currencyconvertor.databinding.NbtFragmentBinding
import com.firuz.currencyconvertor.domain.models.NbtRate
import com.firuz.currencyconvertor.ui.nbtRates.adapter.NbtAdapter

class NBTFragment : Fragment() {

    private var _binding: NbtFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NBTRateViewModel by viewModels(factoryProducer = { NbtViewModelProviderFactory() })

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

        viewModel.uiState.observe(viewLifecycleOwner){
            setLoading(it.isLoading)
            setError(it.errorMessage)
            setupRecyclerView(it.dataSet)
        }
    }

    private fun setLoading(isLoading: Boolean){
        binding.progressBar.isVisible = isLoading
    }

    private fun setError(message: String?){
        binding.errorPanel.isVisible = !message.isNullOrEmpty()
        binding.textViewErrorMessage.text = message

        binding.reloadButton.setOnClickListener {
            viewModel.reload()
        }
    }

    private fun setupRecyclerView(dataset: List<NbtRate>){
        binding.contentPanel.isVisible = dataset.isNotEmpty()
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerView.adapter = NbtAdapter(dataset){
            val action =
                NBTFragmentDirections.actionNavNbtToNavConverter(
                    title = it.name
                )
            findNavController().navigate(action)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}