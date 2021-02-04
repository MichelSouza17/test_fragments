package com.example.testfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
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

    private lateinit var toolbar: Toolbar

    private lateinit var drawer: DrawerLayout

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

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer)

        //*** Adicionar botão que abre o drawer menu
        var toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        setFragment(homeFragment)
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
                toolbar.title = "Home"
                setFragment(homeFragment)
            }
            R.id.menu_console  -> {
                toolbar.title = "Consoles"
                setFragment(consoleFragment)
            }
            R.id.menu_games -> {
                toolbar.title = "Games"
                setFragment(gameFragment)
            }

        }

        // *** Selecionar o item de menu na BottomNavigationView
        var selectedMenu = bottomNavigation.menu.findItem(item.itemId)
        selectedMenu.setChecked(true)

        // ***
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        return true
    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }


}