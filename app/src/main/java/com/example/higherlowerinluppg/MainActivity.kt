package com.example.higherlowerinluppg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView

    val cardList = listOf<Card>(Card(2, R.drawable.two),
        Card(3, R.drawable.three),
        Card(4, R.drawable.four),
        Card(5, R.drawable.five),
        Card(6, R.drawable.six),
        Card(7, R.drawable.seven),
        Card(8, R.drawable.eigth),
        Card(9, R.drawable.nine),
        Card(10, R.drawable.ten),
        Card(11, R.drawable.knekt),
        Card(12, R.drawable.dam),
        Card(13, R.drawable.kung),
        Card(1, R.drawable.ess))

    var randomCard = cardList.random()
    var cardValue = randomCard.value
    var cardImage = randomCard.image
    var currentScore = 0
    var newCardValue = randomCard.value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)


        newCard()

        //val currentCard =



    }

    fun newCard(){
        randomCard = cardList.random()
        cardValue = randomCard.value
        cardImage = randomCard.image
        imageView.setImageResource(cardImage)

    }

    fun onHigher(view: View){
        val newCardValue = randomCard.value
        newCard()
        //newCardValue = randomCard.value
        if(cardValue >= newCardValue) {
            currentScore++
            textView.text = currentScore.toString()
        } else {
            currentScore--
            textView.text = currentScore.toString()
        }
    }

    fun onLower(view: View) {
        val newCardValue = randomCard.value
        newCard()
        if(cardValue <= newCardValue) {
            currentScore++
            textView.text = currentScore.toString()
        } else {
            newActivity()
        }
    }

    fun newActivity() {
        val intent = Intent(this, finalScoreActivity::class.java)
        startActivity(intent)
    }


}