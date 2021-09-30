package com.example.higherlowerinluppg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardRecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_recycle)

        val recyclerView = findViewById<RecyclerView>(R.id.rwCards)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CardRecycleAdapter(this, DataManager.listOfCorrectCards)

        recyclerView.adapter = adapter
    }
}