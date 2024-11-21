package com.akirachix.cupfulcanvasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.cupfulcanvasapp.R

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        val itemName = findViewById<TextView>(R.id.itemName)
        val itemDescription = findViewById<TextView>(R.id.itemDescription)
        val sizeOptions = findViewById<RadioGroup>(R.id.sizeOptions)
        val addToCartButton = findViewById<Button>(R.id.addToCartButton)

        // Get data passed from MenuActivity
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.item1)

        // Set data in the views
        itemName.text = name
        itemDescription.text = description
        findViewById<ImageView>(R.id.itemImage).setImageResource(imageResId)

        // Handle Add to Cart Button
        addToCartButton.setOnClickListener {
            val selectedSize = when (sizeOptions.checkedRadioButtonId) {
                R.id.sizeSmall -> "Small"
                R.id.sizeMedium -> "Medium"
                R.id.sizeLarge -> "Large"
                else -> null
            }

            if (selectedSize == null) {
                Toast.makeText(this, "Please select a size", Toast.LENGTH_SHORT).show()
            } else {
                // Navigate back to the Menu or Cart screen (optional)
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
