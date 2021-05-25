package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        Toast.makeText(applicationContext, "Name Activity", Toast.LENGTH_LONG).show()

        val btnGoName = findViewById<Button>(R.id.btnGoName)
        btnGoName.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnGoName.setOnClickListener {
            finish()
        }
    }
}