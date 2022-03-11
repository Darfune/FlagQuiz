package com.example.flagquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat


class FlagQuizQuestions : AppCompatActivity() {

    private val flags = Constants.getFlags()
    private val countries = Constants.getCountries()
    private var flagImageView: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var progressTextView: TextView? = null
    private var optionOneBtn: Button? = null
    private var optionTwoBtn: Button? = null
    private var optionThreeBtn: Button? = null
    private var optionFourBtn: Button? = null
    private var answer: Int? = null
    private var progress: Int? = 0
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag_quiz_questions)

        flagImageView = findViewById(R.id.flagImageView)
        progressBar =  findViewById(R.id.progressBar)
        progressTextView = findViewById(R.id.progressTextView)
        optionOneBtn = findViewById(R.id.optionOneBtn)
        optionTwoBtn = findViewById(R.id.optionTwoBtn)
        optionThreeBtn = findViewById(R.id.optionThreeBtn)
        optionFourBtn = findViewById(R.id.optionFourBtn)

        createQuestion()

    }

    private fun createQuestion() {
        val selectedCountry = (0..250).random()
        var wrongOne : Int
        var wrongTwo : Int
        var wrongThree : Int
        do {
            wrongOne = (0..250).random()
        }while (wrongOne == selectedCountry)
        do {
            wrongTwo = (0..250).random()
        }while (wrongTwo == selectedCountry && wrongTwo == wrongOne)
        do {
            wrongThree = (0..250).random()
        }while (wrongThree == selectedCountry && wrongThree == wrongOne && wrongThree == wrongTwo)

        answer = (1..4).random()
        flagImageView?.setImageResource(flags.getValue(selectedCountry))
        when (answer){
           1 -> {
               optionOneBtn?.text = countries[selectedCountry]

               optionFourBtn?.text = countries[wrongOne]
               optionTwoBtn?.text = countries[wrongTwo]
               optionThreeBtn?.text = countries[wrongThree]
           }
           2 -> {
               optionTwoBtn?.text = countries[selectedCountry]

               optionOneBtn?.text = countries[wrongOne]
               optionFourBtn?.text = countries[wrongTwo]
               optionThreeBtn?.text = countries[wrongThree]
           }
           3 -> {
               optionThreeBtn?.text = countries[selectedCountry]

               optionOneBtn?.text = countries[wrongOne]
               optionTwoBtn?.text = countries[wrongTwo]
               optionFourBtn?.text = countries[wrongThree]
           }
           4 -> {
               optionFourBtn?.text = countries[selectedCountry]

               optionOneBtn?.text = countries[wrongOne]
               optionTwoBtn?.text = countries[wrongTwo]
               optionThreeBtn?.text = countries[wrongThree]
           }

        }

    }

    @SuppressLint("SetTextI18n")
    fun selectedAnswer(view: View) {
        when (view.id){
            R.id.optionOneBtn ->{
                if (answer == 1){
                    optionOneBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_selected_option_bg
                    )
                    correctAnswers++
                }
                else{
                    optionOneBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_selected_option_bg
                    )
                    when (answer){
                        2 -> optionTwoBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        3 -> optionThreeBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        4 -> optionFourBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                    }
                }
            }
            R.id.optionTwoBtn ->{
                if (answer == 2){
                    optionTwoBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_selected_option_bg
                    )
                    correctAnswers++
                }
                else{
                    optionTwoBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_selected_option_bg
                    )
                    when (answer){
                        1 -> optionOneBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        3 -> optionThreeBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        4 -> optionFourBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                    }
                }
            }
            R.id.optionThreeBtn ->{
                if (answer == 3){
                    optionThreeBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_selected_option_bg
                    )
                    correctAnswers++
                }
                else{
                    optionThreeBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_selected_option_bg
                    )
                    when (answer){
                        2 -> optionTwoBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        1 -> optionOneBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        4 -> optionFourBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                    }
                }
            }
            R.id.optionFourBtn ->{
                if (answer == 4){
                    optionFourBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_selected_option_bg
                    )
                    correctAnswers++
                }
                else{
                    optionFourBtn?.background =  ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_selected_option_bg
                    )
                    when (answer){
                        2 -> optionTwoBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        3 -> optionThreeBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                        1 -> optionOneBtn?.background =  ContextCompat.getDrawable(
                            this,
                            R.drawable.corrent_not_selected_bg
                        )
                    }
                }
            }
        }

        optionOneBtn?.isClickable = false
        optionTwoBtn?.isClickable = false
        optionThreeBtn?.isClickable = false
        optionFourBtn?.isClickable = false

        progress = progress?.plus(1)
        if (progress == 10){
            startActivity(Intent(this, EndActivity::class.java))
            finish()
        }

        progressBar?.progress = progress!!
        progressTextView?.text = "$progress/10"


        Handler(Looper.getMainLooper()).postDelayed({
            optionOneBtn?.background =  ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
            optionTwoBtn?.background =  ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
            optionThreeBtn?.background =  ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
            optionFourBtn?.background =  ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
            createQuestion()
            optionOneBtn?.isClickable = true
            optionTwoBtn?.isClickable = true
            optionThreeBtn?.isClickable = true
            optionFourBtn?.isClickable = true
        }, 1500)


    }

}
