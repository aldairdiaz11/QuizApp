package com.adiaz.quizapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.tv_progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.tv_image)

        tvOptionOne =findViewById(R.id.tv_option_one)
        tvOptionTwo =findViewById(R.id.tv_option_two)
        tvOptionThree =findViewById(R.id.tv_option_three)
        tvOptionFour =findViewById(R.id.tv_option_four)

        val questionsList = Constants.getQuestions()
        Log.i("Question list size: ", "${questionsList.size}")

        for (item in questionsList) {
            Log.e("Question", item.question)
        }

        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]
        tvImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.OptionOne
        tvOptionTwo?.text = question.OptionTwo
        tvOptionThree?.text = question.OptionThree
        tvOptionFour?.text = question.OptionFour
    }
}