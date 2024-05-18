package com.firuz.currencyconvertor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.firuz.currencyconvertor.R
import com.firuz.currencyconvertor.databinding.LayoutActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController =
            (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        val topIdSet = setOf(
                R.id.nav_exchanger,
                R.id.nav_nbt
            )


        NavigationUI.setupWithNavController(
            binding.toolbar, navController, AppBarConfiguration(
                topIdSet
            )
        )


        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.bottomNavigation.isVisible = topIdSet.contains(destination.id)
        }

    }

}


