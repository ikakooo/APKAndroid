package com.example.week9_navigation_drawer_activity.ui

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week9_navigation_drawer_activity.ItemsMenuModel
import com.example.week9_navigation_drawer_activity.adapter.ItemsMenuRecyclerviewAdapter
import com.example.week9_navigation_drawer_activity.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ItemsMenuRecyclerviewAdapter
    private val items = mutableListOf<ItemsMenuModel>()

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun init(){
        adapter =
            ItemsMenuRecyclerviewAdapter(
                items
            )
        itemsMenuRecyclerview.layoutManager = LinearLayoutManager(this)
        itemsMenuRecyclerview.adapter =adapter
        addItems()


    }

    private fun addItems(){
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_camera,
                "Camera"
            )
        )
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_gallery,
                "Gallery"
            )
        )
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_slideshow,
                "Slideshow"
            )
        )
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_camera,
                "Slideshow"
            )
        )
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_gallery,
                "Slideshow"
            )
        )
        items.add(
            ItemsMenuModel(
                R.drawable.ic_menu_slideshow,
                "Slideshow"
            )
        )

    }

}
