package com.example.higherlowerinluppg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    lateinit var tvScore : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        tvScore = findViewById(R.id.tvScore)
        val currentScore = intent.getIntExtra("currentscore", 0)
        tvScore.text = currentScore.toString()
    }

    fun onRestart(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        super.onRestart()
    }


}