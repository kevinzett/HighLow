package com.example.higherlowerinluppg

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.random
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var timeView: Chronometer
    lateinit var timer: TimerTask


    var cardList = CardList()
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

        timeView = findViewById(R.id.timeView)
        timeView.isCountDown = true
        timeView.base = SystemClock.elapsedRealtime() + 10000
        timeView.start()


        newCard()
        startTimer()

    }


    fun newCard() {
        randomCard = cardList.cardList.random()
        cardValue = randomCard.value
        cardImage = randomCard.image
        imageView.setImageResource(cardImage)

    }

    fun onHigher(view: View) {

        val newCardValue = randomCard.value
        newCard()
        if (cardValue >= newCardValue) {
            currentScore++
            DataManager.listOfCorrectCards.add(randomCard)
            textView.text = currentScore.toString()
            refreshTimer()
        } else {
            timer.cancel()
            newActivity()
        }
    }

    fun onLower(view: View) {

        val newCardValue = randomCard.value
        newCard()
        if (cardValue <= newCardValue) {
            currentScore++
            DataManager.listOfCorrectCards.add(randomCard)
            textView.text = currentScore.toString()
            refreshTimer()
        } else {
            timer.cancel()
            newActivity()
        }
    }

    fun newActivity() {
        mediaPlayer.start()
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("currentscore", currentScore)
        startActivity(intent)
    }

    fun startTimer() {

        timer = Timer().schedule(10000) {
            newActivity()
        }
    }

    fun refreshTimer() {
        timer.cancel()
        timeView.base = SystemClock.elapsedRealtime() + 10000
        startTimer()
    }

}