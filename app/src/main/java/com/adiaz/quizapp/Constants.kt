package com.adiaz.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {

        // Questions data:
        val questionStatement = "What does this flag belong to?"

        val flags = arrayOf(
            R.drawable.ic_flag_of_argentina, R.drawable.ic_flag_of_australia,
            R.drawable.ic_flag_of_belgium, R.drawable.ic_flag_of_brazil, R.drawable.ic_flag_of_denmark,
            R.drawable.ic_flag_of_fiji, R.drawable.ic_flag_of_germany, R.drawable.ic_flag_of_india,
            R.drawable.ic_flag_of_kuwait, R.drawable.ic_flag_of_new_zealand)

        val answers = arrayOf(
            0, 1, 2, 3, 1, 2, 3, 1, 2, 3
        )

        val options = arrayOf(
            arrayOf("Argentina", "New Zealand", "Kuwait", "Peru"),
            arrayOf("New Zealand", "Australia", "Denmark", "Portugal"),
            arrayOf("Brazil", "New Zealand", "Belgium", "Russia"),
            arrayOf("Argentina", "Mexico", "Ukrainian", "Brazil"),
            arrayOf("Australia", "Denmark", "Germany", "Uruguay"),
            arrayOf("Canada", "Colombia", "Fiji", "Venezuela"),
            arrayOf("China", "Japan", "South Korea", "Germany"),
            arrayOf("Chile", "India", "Italy", "Finland"),
            arrayOf("Cuba", "Spain", "Kuwait", "Singapore"),
            arrayOf("Kenya", "France", "Azerbaijan","New Zealand")
        )

        val questionsList = ArrayList<Question>()

        for ((index, flag) in flags.withIndex()) {
            val optOne = options[index][0]
            val optTwo = options[index][1]
            val optThree = options[index][2]
            val optFour = options[index][3]

            questionsList.add(
                Question(
                    index + 1, questionStatement, flag, optOne, optTwo, optThree, optFour,
                    answers[index] + 1
                )
            )
        }

        return questionsList
    }
}