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
            remplaceFragment(Fragment_1(),
                R.id.fragmentContainerView8, R.id.fragmentContainerView)
            Toast.makeText(this@MainActivity, "Fragment 1 is changed", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            remplaceFragment(Fragment_2(),
                R.id.fragmentContainerView, R.id.fragmentContainerView8)
            Toast.makeText(this@MainActivity, "Fragment 2 is changed", Toast.LENGTH_SHORT).show()

        }
    }
    private fun remplaceFragment(fragment: Fragment,containerId: Int,otherContainerId:Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)

        val otherFragment = fragmentManager.findFragmentById(otherContainerId)
        if (otherFragment !=null){
            fragmentTransaction.remove(otherFragment)
        }
        fragmentTransaction.commit()
    }

    /*private fun remplaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainerView.id, fragment)
        fragmentTransaction.commit()
    }*/
}

