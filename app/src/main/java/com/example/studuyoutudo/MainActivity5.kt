package com.example.studuyoutudo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader

class MainActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.contacts)
        btn.setOnClickListener(){
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
    }

    fun saveData(view: View){
        val userNameField = findViewById<EditText>(R.id.editTextText)
        val userBiography = findViewById<EditText>(R.id.editTextText1)
        val user_name = userNameField.getText().toString()
        val user_bio = userBiography.getText().toString()

        try{
            val fileOutput = this.openFileOutput("user_data.txt", MODE_PRIVATE)
            fileOutput.write(user_name.toByteArray() + (" ").toByteArray() + user_bio.toByteArray())
            fileOutput.close()

            userNameField.setText(" ")
            userBiography.setText(" ")
        } catch (e: FileNotFoundException){
            e.printStackTrace()
            Toast.makeText(this, "Файл не найден", Toast.LENGTH_LONG).show()
        } catch (e: IOException){
            e.printStackTrace()
            Toast.makeText(this, "Файл не найден ещё раз", Toast.LENGTH_LONG).show()
        }
    }

    fun getData(view: View) {
        try {
            val file = getFileStreamPath("user_data.txt")
            if (file.exists()) {
                val fileInput = openFileInput("user_data.txt")
                val reader = InputStreamReader(fileInput)
                val bn = BufferedReader(reader)

                val stringBuffer = StringBuffer()
                var line: String?

                while (bn.readLine().also { line = it } != null) {
                    stringBuffer.append(line).append("\n")
                }

                Toast.makeText(this, stringBuffer.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Файл не найден", Toast.LENGTH_LONG).show()
            }

        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Ошибка чтения файла", Toast.LENGTH_LONG).show()
        }
    }

}