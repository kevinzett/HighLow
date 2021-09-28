package com.example.higherlowerinluppg

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardRecycleAdapter(val context: Context, val cards: List<Card>) :
    RecyclerView.Adapter<CardRecycleAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CardRecycleAdapter.ViewHolder {

        val itemView = layoutInflater.inflate(R.layout.item_list, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardRecycleAdapter.ViewHolder, position: Int) {
        val card = cards[position]
        holder.iwCheck.setImageResource(R.drawable.check)
        holder.iwCard.setImageResource(card.image)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iwCheck = itemView.findViewById<ImageView>(R.id.iwCheck)
        val iwCard = itemView.findViewById<ImageView>(R.id.iwCard)
    }
}