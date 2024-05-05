package com.example.tamagotchi2

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var musicbtn: Button
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcome = findViewById <pl.droidsonroids.gif.GifImageView>(R.id.welcome)

        musicbtn = findViewById(R.id.musicbtn)
        val musicbtn = findViewById<Button>(R.id.musicbtn)
        musicbtn.setOnClickListener {
            playAudio()
        }




        val secondactbtn = findViewById<Button>(R.id.secondactbtn)
        secondactbtn.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)


        }


    }

    private fun playAudio() {
        val audiourl = "https://archive.org/download/ModjoLadyHearMeTonight/Modjo%20-%20Lady%20%28Hear%20Me%20Tonight%29.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer!!.setDataSource(audiourl)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        }catch (e: IOException){

        }
        Toast.makeText(this, "Audio Started", Toast.LENGTH_LONG).show()
    }

}

class MainActivity10 : AppCompatActivity() {

    private lateinit var musicbtn: Button
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcome = findViewById <pl.droidsonroids.gif.GifImageView>(R.id.welcome)

        musicbtn = findViewById(R.id.musicbtn)
        val musicbtn = findViewById<Button>(R.id.musicbtn)
        musicbtn.setOnClickListener {
            playAudio()
        }




        val secondactbtn = findViewById<Button>(R.id.secondactbtn)
        secondactbtn.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)


        }


    }

    private fun playAudio() {
        val audiourl = "https://archive.org/download/ModjoLadyHearMeTonight/Modjo%20-%20Lady%20%28Hear%20Me%20Tonight%29.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer!!.setDataSource(audiourl)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        }catch (e: IOException){

        }
        Toast.makeText(this, "Audio Started", Toast.LENGTH_LONG).show()
    }

}