package com.example.finalui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finalui.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.chat -> replaceFragment(Chat())
                R.id.profile -> replaceFragment(Profile())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        if(fragment != null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }
    }
}