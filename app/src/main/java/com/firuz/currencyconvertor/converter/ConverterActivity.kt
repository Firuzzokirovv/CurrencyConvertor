package com.firuz.currencyconvertor.converter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firuz.currencyconvertor.databinding.LayoutCurrentyConverterBinding

class ConverterActivity : AppCompatActivity() {
    private lateinit var binding: LayoutCurrentyConverterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutCurrentyConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}