package com.example.testfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.testfragment.fragments.ConsoleFragment
import com.example.testfragment.fragments.GameFragment
import com.example.testfragment.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.drawer_navigation_layout.*

class MainActivity() : AppCompatActivity(), View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

//    private lateinit var bttnHome : Button
//    private lateinit var bttnConsole : Button
//    private lateinit var bttnGames : Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var consoleFragment: ConsoleFragment
    private lateinit var gameFragment: GameFragment

    private lateinit var bottomNavigation : BottomNavigationView

    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_navigation_layout)

//        bttnHome = findViewById(R.id.bttnHome)
//        bttnHome.setOnClickListener(this)
//
//        bttnConsole = findViewById(R.id.bttnConsole)
//        bttnConsole.setOnClickListener(this)
//
//        bttnGames = findViewById(R.id.bttGames)
//        bttnGames.setOnClickListener(this)

        homeFragment = HomeFragment()
        consoleFragment = ConsoleFragment()
        gameFragment = GameFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, homeFragment)
            .commit()
    }
    override fun onClick(v: View){
//        when(v.id){
//            R.id.bttnHome -> {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame, homeFragment)
//                    .commit()
//            }
//            R.id.bttnConsole -> {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame, consoleFragment)
//                    .commit()
//            }
//            R.id.bttGames -> {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame, gameFragment)
//                    .commit()
//            }
//
//        }
//
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_home -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, homeFragment)
                    .commit()
            }
            R.id.menu_console  -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, consoleFragment)
                    .commit()
            }
            R.id.menu_games -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, gameFragment)
                    .commit()
            }

        }
        return true
    }


}