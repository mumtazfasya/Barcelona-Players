package com.dicoding.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class AboutPage : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val btnMove: ImageView = findViewById(R.id.image_view1)
        btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.image_view1 -> {
                val moveIntent = Intent(this@AboutPage, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

}