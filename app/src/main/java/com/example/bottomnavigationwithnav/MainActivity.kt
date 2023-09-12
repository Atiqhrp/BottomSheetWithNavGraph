package com.example.bottomnavigationwithnav

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigationwithnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    var binding: ActivityMainBinding? = null
    private var navController: NavController? = null
    var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController
        navController?.addOnDestinationChangedListener(this)

        binding?.run {
            navController?.let { binding?.bottomNavView?.setupWithNavController(it) }
            bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.fragment_home -> {
                        // Handle Home item click
                        navController?.navigate(R.id.idHomeFragment)
                        true
                    }

                    R.id.fragment_more -> {
                        // Handle Search item click
                        navController?.navigate(R.id.idMoreFragment)

                        true
                    }

                    else -> false
                }
            }
        }
    }

    override fun onDestinationChanged(
        controller: NavController, destination: NavDestination,
        arguments: Bundle?
    ) {
        binding?.run {
            when (destination.id) {
                R.id.idHomeFragment, R.id.idMoreFragment -> {
                    bottomNavView.visibility = View.VISIBLE
                }

                R.id.idInnerFragment -> {
                    bottomNavView.visibility = View.GONE
                }
            }
        }
    }

}