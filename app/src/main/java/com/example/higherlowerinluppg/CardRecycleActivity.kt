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

        //skapa en adapter från vår adapter-klass, skicka med vår lista
        val adapter = CardRecycleAdapter(this, DataManager.listOfCorrectCards)

        // koppla ihop vår adapter mec recycleview
        recyclerView.adapter = adapter
    }
}