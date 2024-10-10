package com.example.studuyoutudo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun toastMe(view:View){
        val myToast = Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show()
    }

    fun count(view: View){
        val textView1 = findViewById<TextView>(R.id.textView)
        var count = Integer.parseInt(textView1.text.toString())
        count++
        textView1.text = count.toString()
    }

    fun newIntent(view: View){
        val intent = Intent(this, MainActivity2::class.java)
        var count = findViewById<TextView>(R.id.textView).text.toString()
        var count1= Random.nextInt(count.toInt())
        intent.putExtra(MainActivity2.TOTAL_COUNT, count1)
        startActivity(intent)
    }
}