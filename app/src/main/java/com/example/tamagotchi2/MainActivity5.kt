package com.example.tamagotchi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)



        val bath = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.bath)

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val Intent = Intent(this, MainActivity2 ::class.java)
            startActivity(Intent)



        }
    }
}