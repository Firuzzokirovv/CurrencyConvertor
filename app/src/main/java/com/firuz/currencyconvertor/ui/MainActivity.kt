package com.firuz.currencyconvertor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.databinding.LayoutActivityMainBinding
import com.firuz.currencyconvertor.ui.nbtRates.NBTFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityMainBinding
    private lateinit var nbtFragment: NBTFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nbtFragment = NBTFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, nbtFragment)
            .commit()


    }

}


