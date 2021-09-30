package com.example.higherlowerinluppg

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    var cardList = CardList()
    lateinit var mediaPlayer: MediaPlayer


    var randomCard = cardList.cardList.random()
    var cardValue = randomCard.value
    var cardImage = randomCard.image
    var currentScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        mediaPlayer = MediaPlayer.create(this, R.raw.canopen_1)


        newCard()

    }




    fun newCard(){
        randomCard = cardList.cardList.random()
        cardValue = randomCard.value
        cardImage = randomCard.image
        imageView.setImageResource(cardImage)

    }

    fun onHigher(view: View){

        val newCardValue = randomCard.value
        newCard()
        if(cardValue >= newCardValue) {
            currentScore++
            DataManager.listOfCorrectCards.add(randomCard)
            textView.text = currentScore.toString()
        } else {
            mediaPlayer.start()
            newActivity()
        }
    }

    fun onLower(view: View) {

        val newCardValue = randomCard.value
        newCard()
        if(cardValue <= newCardValue) {
            currentScore++
            DataManager.listOfCorrectCards.add(randomCard)
            textView.text = currentScore.toString()
        } else {
            mediaPlayer.start()
            newActivity()
        }
    }

    fun newActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("currentscore", currentScore)
        startActivity(intent)
    }

}