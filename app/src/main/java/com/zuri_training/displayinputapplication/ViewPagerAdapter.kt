package com.zuri_training.displayinputapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var logoTitle: List<String>, private var logoAbout: List<String>, private var images: List<Int>)
    : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.logoTitle)
        val itemAbout: TextView = itemView.findViewById(R.id.logoAbout)
        val itemImage: ImageView = itemView.findViewById(R.id.logoImage)

        init {
            itemImage.setOnClickListener{
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item number ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun getItemCount(): Int {
        return logoTitle.size
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = logoTitle[position]
        holder.itemAbout.text = logoAbout[position]
        holder.itemImage.setImageResource(images[position])
    }
}