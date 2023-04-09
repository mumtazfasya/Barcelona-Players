package com.dicoding.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvPlayers: RecyclerView
    private val list = ArrayList<Players>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)

        list.addAll(getListPlayers())
        showRecyclerList()

        val btnMoveActivity: ImageView = findViewById(R.id.about_page)
        btnMoveActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun getListPlayers(): ArrayList<Players> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.brief_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataContext = resources.getStringArray(R.array.content_text)
        val dataAppereances = resources.getStringArray(R.array.content_appereances)
        val dataGoal = resources.getStringArray(R.array.content_goals)
        val dataWin = resources.getStringArray(R.array.content_wins)
        val listPlayers = ArrayList<Players>()
        for (i in dataName.indices) {
            val players = Players(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataContext[i], dataAppereances[i], dataGoal[i], dataWin[i])
            listPlayers.add(players)
        }
        return listPlayers
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListPlayersAdapter(list)
        rvPlayers.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListPlayersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Players) {
                showSelectedPlayers(data)
            }
        })
    }

    private fun showSelectedPlayers(players: Players) {
        Toast.makeText(this, "Kamu memilih " + players.name, Toast.LENGTH_SHORT).show()

        val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithObjectIntent.putExtra(DetailActivity.EXTRA_PERSON, players)
        startActivity(moveWithObjectIntent)
    }
}