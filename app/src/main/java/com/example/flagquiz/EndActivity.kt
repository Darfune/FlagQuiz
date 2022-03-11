package com.example.flagquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EndActivity : AppCompatActivity() {



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        var usernameResultsTextView = findViewById<TextView>(R.id.usernameResultsTextView)
        var scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val retryBtn = findViewById<Button>(R.id.retryBtn)
        val usernameResults = intent.getStringExtra(Constants.userName)
        usernameResultsTextView.text = intent.getStringExtra(Constants.userName)
        scoreTextView.text = intent.getStringExtra(Constants.correctAnswers) + "/10"

        retryBtn.setOnClickListener {
            val intent = Intent(this, FlagQuizQuestions::class.java)
            intent.putExtra(Constants.userName,usernameResults)
            startActivity(intent)
        }

    }
}