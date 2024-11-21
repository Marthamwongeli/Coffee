package com.akirachix.cupfulcanvasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cupfulcanvasapp.MenuAdapter

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuRecyclerView = findViewById<RecyclerView>(R.id.menuRecyclerView)

        // Create a list of menu items
        val menuList = listOf(
            MenuItem(R.drawable.item1, "Caramel Latte", "A rich, creamy latte with caramel syrup."),
            MenuItem(R.drawable.item2, "Espresso", "Strong and bold espresso shot."),
            MenuItem(R.drawable.item3, "Cappuccino", "Frothy and delightful cappuccino."),
            MenuItem(R.drawable.item4, "Mocha", "Chocolate-flavored coffee."),
            MenuItem(R.drawable.item5, "Iced Coffee", "Chilled coffee for hot days.")
        )

        // Set up the RecyclerView
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.adapter = MenuAdapter(menuList)
    }
}
