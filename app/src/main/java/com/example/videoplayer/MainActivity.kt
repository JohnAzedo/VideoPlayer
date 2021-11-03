package com.example.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navigation = findViewById(R.id.bottom_navigation)
        navigation.setupWithNavController(navHost.navController)
        hideBottomBar(false)
    }

    fun hideBottomBar(hide: Boolean){
        navigation.visibility = when(hide) {
            true -> View.GONE
            false -> View.VISIBLE
        }
    }
}