package com.example.testfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.adapter.ConsoleAdapter
import com.example.testfragment.dao.Database
import com.example.testfragment.fragments.ConsoleFragment
import com.example.testfragment.fragments.GameFragment
import com.example.testfragment.fragments.HomeFragment
import com.example.testfragment.model.Console
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.drawer_navigation_layout.*

class MainActivity() : AppCompatActivity(), View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var buttonNovoConsole: ImageButton
    private lateinit var editName: EditText
    private lateinit var editDate: EditText
    private lateinit var editDescription: EditText
    private lateinit var editMaker: EditText
    private lateinit var editImage: ImageView
    private lateinit var buttonSalvar: Button
    private lateinit var buttonCancelar: Button
    private lateinit var dialog: AlertDialog
    private lateinit var recycleConsoles: RecyclerView

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

    /* Teste */


    override fun onClick(v: View){
       if (v.id == R.id.button_novo_console){
            abrirCadastroConsole()
        }else if(v.id == R.id.button_cancelar){
            dialog.dismiss()
        }else if (v.id == R.id.button_salvar){
            exibirConsole()
            dialog.dismiss()
        }else{
            salvarConsole()
        }

    }


    private fun exibirConsole(){

        val consoleDao = Database.getDatabase(this).consoleDao()

        val consoles = consoleDao.listarTodos()

        // *** Definir o layout da recyclerView
        recycleConsoles.layoutManager = LinearLayoutManager(this)

        // *** Instaciar o Adapter que será utilizado pelo RecyclerView
        // *** Para carregar os dados
        val adapter = ConsoleAdapter()
        adapter.updateConsoleList(consoles)

        // *** Definir o adapter que será usado pela recyclerview
        recycleConsoles.adapter = adapter

    }

    private fun salvarConsole() {
        var console = Console(
            consoleName = editName.text.toString(),
            consoleReleaseDate = editDate.text.toString(),
            consoleDescription = editDescription.text.toString(),
            consoleMaker = editMaker.text.toString(),
            consoleImage = editImage.drawable)

        val consoleDao = Database.getDatabase(this).consoleDao()
        consoleDao.salvar(console)

        exibirConsole()
    }

    private fun abrirCadastroConsole() {
        val alertDialog = AlertDialog.Builder(this)

        val view = layoutInflater.inflate(R.layout.cadastro_console, null)
        alertDialog.setView(view)

        editName = view.findViewById(R.id.edit_name)
        editDate = view.findViewById(R.id.edit_date)
        editDescription = view.findViewById(R.id.edit_description)
        editMaker = view.findViewById(R.id.edit_maker)
        editImage = view.findViewById(R.id.edit_image)

        buttonSalvar = view.findViewById(R.id.button_salvar)
        buttonCancelar = view.findViewById(R.id.button_cancelar)

        buttonCancelar.setOnClickListener(this)
        buttonSalvar.setOnClickListener(this)

        dialog = alertDialog.create()
        dialog.setCancelable(false)
        dialog.show()

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