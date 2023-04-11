package com.adiaz.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "Brazil", "Germany", "Argentina", 3
        )

        questionsList.add(que1)

        return questionsList
    }
}