package com.dicoding.myapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPlayers: ImageView = findViewById(R.id.img_players)
        val nmPlayers: TextView = findViewById(R.id.name_players)
        val nmBrief: TextView = findViewById(R.id.name_brief)
        val nmContext: TextView = findViewById(R.id.name_context)
        val nmApperance: TextView = findViewById(R.id.name_appereances)
        val nmGoals: TextView = findViewById(R.id.name_goals)
        val nmAccuracy: TextView = findViewById(R.id.name_accuracy)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Players>(EXTRA_PERSON)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null) {
            val imagePlayer = person.photo
            imgPlayers.setImageResource(imagePlayer)
            val namePlayer = person.name
            nmPlayers.text = namePlayer
            val nameBrief = person.description
            nmBrief.text = nameBrief
            val nameContext = person.context
            nmContext.text = nameContext
            val nameApperance = person.appereance
            nmApperance.text = nameApperance
            val nameGoals = person.goals
            nmGoals.text = nameGoals
            val nameAccuracy = person.win
            nmAccuracy.text = nameAccuracy
        }

        val btnShare = findViewById<TextView>(R.id.action_share)
        btnShare.setOnClickListener(this)

        val btnMove: ImageView = findViewById(R.id.image_view1)
        btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val shareBody = "Download our app = https://www.youtube.com/watch?v=HlOb3VLZ-zE"

        val shrIntent = Intent(Intent.ACTION_SEND)
        shrIntent.type = "text/plain"

        shrIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

        startActivity(shrIntent)

        when (v?.id) {
            R.id.image_view1 -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }

    }
}