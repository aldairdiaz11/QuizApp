package com.adiaz.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var absCurrentPosition: Int = 1
    private var absQuestionsList: ArrayList<Question>? = null
    private var absSelectedOptPos: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.tv_progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.tv_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

        btnSubmit = findViewById(R.id.btn_submit)
        absQuestionsList = Constants.getQuestions()

        // Make tv clickable
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question: Question = absQuestionsList!![absCurrentPosition - 1]

        defaultOptionsView()

        tvImage?.setImageResource(question.image)
        progressBar?.progress = absCurrentPosition
        tvProgress?.text = "$absCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.OptionOne
        tvOptionTwo?.text = question.OptionTwo
        tvOptionThree?.text = question.OptionThree
        tvOptionFour?.text = question.OptionFour

        btnSubmit?.text = "SUBMIT"
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)

                }
            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {
                if(absSelectedOptPos == 0){
                    absCurrentPosition ++

                    when{
                        absCurrentPosition <= absQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            Toast.makeText(this
                                ,
                                "Congrats, you made it!",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = absQuestionsList?.get(absCurrentPosition - 1)

                    if(question!!.correctAnswer != absSelectedOptPos) {
                        answerView(absSelectedOptPos, R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(absCurrentPosition == absQuestionsList!!.size) {
                        btnSubmit?.text = "Finish"
                    } else {
                        btnSubmit?.text = "Go to next question"
                    }

                    absSelectedOptPos = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 ->{
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 ->{
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 ->{
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 ->{
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
    private fun selectedOptionView(tv: TextView, optNum: Int) {
        defaultOptionsView()
        absSelectedOptPos = optNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }
}
