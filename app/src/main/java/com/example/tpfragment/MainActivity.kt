package com.example.tpfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tpfragment.Fragment_1
import com.example.tpfragment.Fragment_2
import com.example.tpfragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            remplaceFragment(binding.fragmentContainerView.id,Fragment_2())
            remplaceFragment(binding.fragmentContainerView8.id,Fragment_1())
            Toast.makeText(this@MainActivity, "Fragment 1 is changed", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            remplaceFragment(binding.fragmentContainerView.id,Fragment_1())
            remplaceFragment(binding.fragmentContainerView8.id,Fragment_2())
            Toast.makeText(this@MainActivity, "Fragment 2 is changed", Toast.LENGTH_SHORT).show()

        }
    }

    private fun remplaceFragment(containerViewId : Int,fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commit()
    }
}

