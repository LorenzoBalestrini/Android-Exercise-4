package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.ActivityListBinding
import com.example.myfirstapplication.databinding.ActivityMainBinding

private lateinit var binding: ActivityListBinding
private lateinit var appBarConfiguration: AppBarConfiguration


class ListActivity : AppCompatActivity() {

    val games = listOf(
        GamesList("Dark Souls"),
        GamesList("Devil May Cry"),
        GamesList("Pokémon"),
        GamesList("Outer Wilds"),
        GamesList("BioShock"),
        GamesList("Monster Hunter"),
        GamesList("Metal Gear Solid"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")


        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.fragment_container_view_list)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val list = findViewById<RecyclerView>(R.id.games_list)
        val adapter = GamesAdapter(games)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState Called")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container_view_list)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()    }
}