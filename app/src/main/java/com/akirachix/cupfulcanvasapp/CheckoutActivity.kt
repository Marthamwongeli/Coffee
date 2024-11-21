package com.akirachix.cupfulcanvasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cupfulcanvasapp.CartAdapter

class CheckoutActivity : AppCompatActivity() {
    private val cartList = mutableListOf<CartItem>() // Sample cart list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val checkoutRecyclerView = findViewById<RecyclerView>(R.id.checkoutRecyclerView)
        val deliveryAddressInput = findViewById<EditText>(R.id.deliveryAddressInput)
        val contactNumberInput = findViewById<EditText>(R.id.contactNumberInput)
        val paymentMethodGroup = findViewById<RadioGroup>(R.id.paymentMethodGroup)
        val totalPriceCheckout = findViewById<TextView>(R.id.totalPriceCheckout)
        val confirmOrderButton = findViewById<Button>(R.id.confirmOrderButton)

        // Sample cart data
        cartList.add(CartItem(R.drawable.item1, "Caramel Latte", "Medium", 4.50))
        cartList.add(CartItem(R.drawable.item2, "Espresso", "Small", 2.50))

        // Set up RecyclerView
        checkoutRecyclerView.layoutManager = LinearLayoutManager(this)
        checkoutRecyclerView.adapter = CartAdapter(cartList) { cartItem ->
            Toast.makeText(this, "Cannot remove items during checkout", Toast.LENGTH_SHORT).show()
        }

        // Calculate total price
        val totalPrice = cartList.sumOf { it.price }
        totalPriceCheckout.text = "Total: $${String.format("%.2f", totalPrice)}"

        // Handle Confirm Order Button
        confirmOrderButton.setOnClickListener {
            val address = deliveryAddressInput.text.toString()
            val contact = contactNumberInput.text.toString()
            val selectedPaymentMethodId = paymentMethodGroup.checkedRadioButtonId
            val paymentMethod = when (selectedPaymentMethodId) {
                R.id.paymentCash -> "Cash on Delivery"
                R.id.paymentCard -> "Credit/Debit Card"
                else -> null
            }

            if (address.isEmpty() || contact.isEmpty() || paymentMethod == null) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ThankYouActivity::class.java)
                startActivity(intent)
                finish()// Close CheckoutActivity
            }
        }
    }
}
