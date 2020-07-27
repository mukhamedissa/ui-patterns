class SurveysActivity : SurveyView {

    private val presenter = SurveyPresenter(
        view = this,
        repository = SurveyRepository()
    )

    fun onCreate() {
        presenter.loadSurveys()
    }

    override fun showLoading() {
        println("loading shown")
    }

    override fun showSurveys(surveys: List<Survey>) {
        println(surveys)
    }

    override fun hideLoading() {
        println("loading hidden")
    }
}