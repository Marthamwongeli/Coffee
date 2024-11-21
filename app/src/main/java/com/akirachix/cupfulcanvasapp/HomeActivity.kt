package com.akirachix.cupfulcanvasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val categoryColdCoffee = findViewById<Button>(R.id.categoryColdCoffee)
        val categoryHotCoffee = findViewById<Button>(R.id.categoryHotCoffee)

        // Handle Cold Coffee Button Click
        categoryColdCoffee.setOnClickListener {
            Toast.makeText(this, "Cold Coffee Category Clicked", Toast.LENGTH_SHORT).show()
        }

        // Handle Hot Coffee Button Click
        categoryHotCoffee.setOnClickListener {
            Toast.makeText(this, "Hot Coffee Category Clicked", Toast.LENGTH_SHORT).show()
        }
        val menuButton = findViewById<Button>(R.id.menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}
