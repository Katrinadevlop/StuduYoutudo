package com.example.studuyoutudo

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton2)
        val media = MediaPlayer.create(this, R.raw.music)
        val media1 = MediaPlayer.create(this, R.raw.music1)

        imageButton.setOnClickListener(){
            soundPlayButton(media, media1)
        }

        imageButton1.setOnClickListener(){
            soundPlayButton(media1, media)
        }
    }

    private fun soundPlayButton(mediaPlayer: MediaPlayer, mediaPlayer1: MediaPlayer) {
        if (mediaPlayer.isPlaying || mediaPlayer1.isPlaying){
            mediaPlayer.stop()
            mediaPlayer1.stop()
            mediaPlayer.prepare()
            mediaPlayer1.prepare()
        }
        mediaPlayer.start()
        mediaPlayer.isLooping
    }

    fun IntentMy(view: View){
        val intent = Intent(this, MainActivity4::class.java)
        startActivity(intent)
    }
}