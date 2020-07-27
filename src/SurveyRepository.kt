class SurveyRepository {

    fun getSurveys(): List<Survey> {
        return listOf(
            Survey(name = "Survey 1"),
            Survey(name = "Survey 2"),
            Survey(name = "Survey 3")
        )
    }
}

data class Survey(
    val name: String
)