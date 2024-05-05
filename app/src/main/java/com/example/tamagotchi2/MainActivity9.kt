package com.example.tamagotchi2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main9)

        val playing = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.playing )
        playing .alpha= 0f
        playing .animate().setDuration(10000).alpha( 1f).withEndAction{
            val i = Intent(this,MainActivity4 ::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}