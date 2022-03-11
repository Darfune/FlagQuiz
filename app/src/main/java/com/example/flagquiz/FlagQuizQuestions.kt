package com.example.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.*
import kotlin.random.Random.Default.nextInt


class FlagQuizQuestions : AppCompatActivity() {

    private var flagImageView: ImageView? = null
    private val flags = Constants.getFlags()
    private val countries = Constants.getCountries()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag_quiz_questions)

        flagImageView = findViewById(R.id.flagImageView)





        var id = (0..250).random()


        flagImageView?.setImageResource(flags.getValue(id))


    }

}
