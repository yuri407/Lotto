package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CardView2 = findViewById<CardView>(R.id.CardView2)
        CardView2.setOnClickListener{
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }
    }
}