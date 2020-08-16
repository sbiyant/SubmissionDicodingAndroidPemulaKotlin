package com.example.mysubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFootballClub: RecyclerView
    private var list: ArrayList<FootballClub> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Premiere League Football Club"

        rvFootballClub = findViewById(R.id.rv_football_club)
        rvFootballClub.setHasFixedSize(true)

        list.addAll(FootballClubData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvFootballClub.layoutManager = LinearLayoutManager(this)
        val listFootballClubAdapter = ListFootballClubAdapter(list)
        rvFootballClub.adapter = listFootballClubAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about_me->{
                val intentAboutMeActivity = Intent(this@MainActivity,
                    AboutMeActivity::class.java)
                startActivity(intentAboutMeActivity)
            }
        }
    }

}