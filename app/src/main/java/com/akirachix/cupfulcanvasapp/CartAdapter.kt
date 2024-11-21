package com.example.cupfulcanvasapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.cupfulcanvasapp.CartItem
import com.akirachix.cupfulcanvasapp.R

class CartAdapter(
    private val cartList: MutableList<CartItem>,
    private val onRemoveClick: (CartItem) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartItemImage: ImageView = itemView.findViewById(R.id.cartItemImage)
        val cartItemName: TextView = itemView.findViewById(R.id.cartItemName)
        val cartItemSize: TextView = itemView.findViewById(R.id.cartItemSize)
        val removeItemButton: Button = itemView.findViewById(R.id.removeItemButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartList[position]
        holder.cartItemImage.setImageResource(cartItem.imageResId)
        holder.cartItemName.text = cartItem.name
        holder.cartItemSize.text = "Size: ${cartItem.size}"
        holder.removeItemButton.setOnClickListener { onRemoveClick(cartItem) }
    }

    override fun getItemCount(): Int = cartList.size
}
