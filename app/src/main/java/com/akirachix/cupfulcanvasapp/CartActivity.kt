package com.akirachix.cupfulcanvasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cupfulcanvasapp.CartAdapter

class CartActivity : AppCompatActivity() {
    private val cartList = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)
        val totalPriceText = findViewById<TextView>(R.id.totalPriceText)

        // Sample data
        cartList.add(CartItem(R.drawable.item1, "Caramel Latte", "Medium", 4.50))
        cartList.add(CartItem(R.drawable.item2, "Espresso", "Small", 2.50))
        cartList.add(CartItem(R.drawable.item3, "Cappuccino", "Large", 5.00))

        // Update total price
        updateTotalPrice(totalPriceText)

        // Set up RecyclerView
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = CartAdapter(cartList) { cartItem ->
            cartList.remove(cartItem)
            updateTotalPrice(totalPriceText)
            Toast.makeText(this, "${cartItem.name} removed from cart", Toast.LENGTH_SHORT).show()
            cartRecyclerView.adapter?.notifyDataSetChanged()
        }

        // Handle Checkout Button
        findViewById<Button>(R.id.checkoutButton).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

    }

    private fun updateTotalPrice(totalPriceText: TextView) {
        val total = cartList.sumOf { it.price }
        totalPriceText.text = "Total: $${String.format("%.2f", total)}"
    }
}
