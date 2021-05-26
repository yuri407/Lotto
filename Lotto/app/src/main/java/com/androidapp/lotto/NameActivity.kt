package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val btnGo= findViewById<Button>(R.id.btnGo)
        btnGo.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}