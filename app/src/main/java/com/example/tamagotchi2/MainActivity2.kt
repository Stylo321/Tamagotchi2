package com.example.tamagotchi2


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class Tamagotchi {
    var hunger = 0
    var happiness = 100
    var cleanliness = 100

    fun feed() {
        hunger = (hunger - 10).coerceAtLeast(0)
    }

    fun play() {
        happiness = (happiness + 10).coerceAtMost(100)
    }

    fun clean() {
        cleanliness = (cleanliness + 10).coerceAtMost(100)
    }

    fun starve() {
        hunger = (hunger + 10).coerceAtMost(100)
    }
    fun reduceHappiness() {
        happiness = (happiness - 5).coerceAtLeast(0)
    }
    fun reduceCleanliness() {
        cleanliness = (cleanliness - 5).coerceAtLeast(0)
    }
}

class MainActivity2 : AppCompatActivity() {
    private lateinit var tamagotchi: Tamagotchi
    private lateinit var hungerTextView: TextView
    private lateinit var happinessTextView: TextView
    private lateinit var cleanlinessTextView: TextView
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize TextView elements
        hungerTextView = findViewById(R.id.hungerTextView)
        happinessTextView = findViewById(R.id.happinessTextView)
        cleanlinessTextView = findViewById(R.id.cleanlinessTextView)

        // Initialize Tamagotchi
        tamagotchi = Tamagotchi()

        // Set up Button click listeners
        val feedButton: Button = findViewById(R.id.feedButton)
        feedButton.setOnClickListener {
            tamagotchi.feed()
            updateUI()
            val intent = Intent(this, MainActivity7 ::class.java)
            startActivity(intent)
            Toast.makeText(this,"I am Eating",Toast.LENGTH_LONG).show()
        }

        val playButton: Button = findViewById(R.id.playButton)
        playButton.setOnClickListener {
            tamagotchi.play()
            updateUI()
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
            Toast.makeText(this,"I am Playing",Toast.LENGTH_LONG).show()
        }

        val cleanButton: Button = findViewById(R.id.cleanButton)
        cleanButton.setOnClickListener {
            tamagotchi.clean()
            updateUI()
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
            Toast.makeText(this,"Im taking a bath",Toast.LENGTH_LONG).show()
        }
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            val intent = Intent ( this,MainActivity :: class.java )
            startActivity(intent)
        }

        // declare gif
        val gifImageView2 = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.gifImageView2)
        val cupid = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.cupid)


        // Start a timer to increase hunger over time
        handler.postDelayed(object : Runnable {
            override fun run() {
                tamagotchi.starve()
                updateUI()
                handler.postDelayed(this, 10000) // Every 10 seconds
            }
        }, 10000) // Initial delay of 10 seconds

        // Set up timer to decrease happiness every 15 seconds
        handler.postDelayed(object : Runnable {
            override fun run() {
                tamagotchi.reduceHappiness()
                updateUI()
                handler.postDelayed(this, 15000) // Every 15 seconds
            }
        }, 15000)


        // Set up timer to decrease cleanliness every 15 seconds
        handler.postDelayed(object : Runnable {
            override fun run() {
                tamagotchi.reduceCleanliness()
                updateUI()
                handler.postDelayed(this, 15000) // Every 15 seconds
            }
        }, 15000)


        // Initial UI update
        updateUI()


    }




    private fun updateUI() {
        hungerTextView.text = "Hunger: ${tamagotchi.hunger}"
        happinessTextView.text = "Happiness: ${tamagotchi.happiness}"
        cleanlinessTextView.text = "Cleanliness: ${tamagotchi.cleanliness}"
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null) // Clean up all callbacks to prevent memory leaks
    }
}