package com.example.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startQuizBtn : Button = findViewById(R.id.startQuizBtn)
        var nameEditText : EditText = findViewById(R.id.nameEditText)
        startQuizBtn.setOnClickListener {
            if (nameEditText.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, FlagQuizQuestions::class.java)
                intent.putExtra(Constants.userName, nameEditText.text.toString())
                startActivity(intent)
                finish()

            }
        }


    }
}