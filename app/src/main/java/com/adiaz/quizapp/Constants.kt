package com.adiaz.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {

        // Questions data:
        val questionStatement: String = "What does this flag belong to?"

        val flags = arrayOf<Int>(
            R.drawable.ic_flag_of_argentina, R.drawable.ic_flag_of_australia,
            R.drawable.ic_flag_of_belgium, R.drawable.ic_flag_of_brazil, R.drawable.ic_flag_of_denmark,
            R.drawable.ic_flag_of_fiji, R.drawable.ic_flag_of_germany, R.drawable.ic_flag_of_india,
            R.drawable.ic_flag_of_kuwait, R.drawable.ic_flag_of_new_zealand)

        val answers = arrayOf<String>(
            "Argentina", ""
        )

        val questionsList = ArrayList<Question>()

        for ((index, flag) in flags.withIndex()) {
            questionsList.add(
                Question(
                    1, questionStatement, flag,
                    "Brazil", "Germany", "Argentina",
                    "India", 3
                )
            )
        }

        return questionsList
    }
}