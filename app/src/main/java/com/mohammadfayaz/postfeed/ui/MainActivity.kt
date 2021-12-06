package com.mohammadfayaz.postfeed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.mohammadfayaz.postfeed.R
import com.mohammadfayaz.postfeed.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private lateinit var navHostFragment: NavHostFragment
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    installSplashScreen()

    binding = ActivityMainBinding.inflate(layoutInflater)

    setContentView(binding.root)

    registerViewEvents()
  }

  private fun registerViewEvents() {
    navHostFragment =
      supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

    navController = navHostFragment.navController

    setupActionBarWithNavController(navController)
  }

  override fun onBackPressed() {
    if (!navController.navigateUp())
      super.onBackPressed()
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
  }
}
