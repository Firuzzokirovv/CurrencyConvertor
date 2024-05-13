package com.firuz.currencyconvertor.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.databinding.LayoutActivityMainBinding
import com.firuz.currencyconvertor.ui.converter.ConverterFragment
import com.firuz.currencyconvertor.ui.exchanger.ExchangerFragment
import com.firuz.currencyconvertor.ui.nbtRates.NBTFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityMainBinding
    private lateinit var nbtFragment: NBTFragment
    private lateinit var converterFragment: ConverterFragment
    private lateinit var exchangerFragment: ExchangerFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nbtFragment = NBTFragment()
        converterFragment = ConverterFragment()
        exchangerFragment = ExchangerFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, nbtFragment)
            .commit()

        binding.headerTitleTextView.text = "Курсы НБТ"


        binding.buttonNavigation.setOnClickListener() {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, nbtFragment)
                .commit()

            binding.headerTitleTextView.text = "Курсы НБТ"

        }

        binding.buttonNavigation.setOnClickListener() {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, exchangerFragment)
                .commit()

            binding.headerTitleTextView.text = "Обменники"

        }












    }

}


