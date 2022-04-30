package com.github.didahdx.adaniandemoui.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.github.didahdx.adaniandemoui.R
import com.github.didahdx.adaniandemoui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.include.toolbarSearch)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.projectsFragment,
            R.id.calendarFragment, R.id.chatFragment, R.id.statisticsFragment
        ).build()
//        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }

    fun setActionBars(view: Toolbar) {
        setSupportActionBar(view)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}