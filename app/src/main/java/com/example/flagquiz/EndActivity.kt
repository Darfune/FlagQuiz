package com.example.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {

    private var usernameResultsTextView: TextView? = null
    private var scoreTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        usernameResultsTextView = findViewById(R.id.usernameResultsTextView)
        scoreTextView = findViewById(R.id.scoreTextView)


    }
}