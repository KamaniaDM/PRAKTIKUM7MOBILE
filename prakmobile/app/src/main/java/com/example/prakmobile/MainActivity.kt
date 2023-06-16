package com.example.prakmobile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.prakmobile.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("unused")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var modeSwitch: SwitchCompat
    private var nightMode:Boolean=false
    private var editor:SharedPreferences.Editor?=null
    private var sharedPreferences:SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_drama, R.id.navigation_film
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        modeSwitch= findViewById(R.id.mode_switch)
        sharedPreferences= getSharedPreferences("MODE", Context.MODE_PRIVATE)
        nightMode=sharedPreferences?.getBoolean("night",false)!!
        if (nightMode){
            modeSwitch.isChecked=true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        modeSwitch.setOnCheckedChangeListener { compoundButton, state ->
            if (nightMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor=sharedPreferences?.edit()
                editor?.putBoolean("night",false)
            }

            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor=sharedPreferences?.edit()
                editor?.putBoolean("night",true)
            }
            editor?.apply()
        }
        }
    }
