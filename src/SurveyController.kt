class SurveyController {

    private val repository = SurveyRepository()

    fun loadSurveys() {
        val surveys = repository.getSurveys()

        showSurveys(surveys)
    }

    private fun showSurveys(surveys: List<Survey>) {
        //showing surveys in recyclerview or tableview
    }
}