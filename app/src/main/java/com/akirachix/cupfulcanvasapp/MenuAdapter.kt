package com.example.cupfulcanvasapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.cupfulcanvasapp.ItemDetailsActivity
import com.akirachix.cupfulcanvasapp.MenuItem
import com.akirachix.cupfulcanvasapp.R

class MenuAdapter(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuItemImage: ImageView = itemView.findViewById(R.id.menuItemImage)
        val menuItemName: TextView = itemView.findViewById(R.id.menuItemName)
        val menuItemDescription: TextView = itemView.findViewById(R.id.menuItemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuList[position]
        holder.menuItemImage.setImageResource(menuItem.imageResId)
        holder.menuItemName.text = menuItem.name
        holder.menuItemDescription.text = menuItem.description

        // Set click listener for item
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ItemDetailsActivity::class.java)
            intent.putExtra("name", menuItem.name)
            intent.putExtra("description", menuItem.description)
            intent.putExtra("imageResId", menuItem.imageResId)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = menuList.size
}
