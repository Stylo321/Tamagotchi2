package com.example.tamagotchi2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)


        val face = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.face)
        face.alpha= 0f
        face.animate().setDuration(6000).alpha( 1f).withEndAction{
            val i = Intent(this,MainActivity2 ::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}
