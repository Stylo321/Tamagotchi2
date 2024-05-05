package com.example.tamagotchi2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        val feeding = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.feeding)
        feeding.alpha= 0f
        feeding.animate().setDuration(10000).alpha( 1f).withEndAction{
            val i = Intent(this,MainActivity3 ::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}