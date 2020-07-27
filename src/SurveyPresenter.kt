interface SurveyView {
    fun showLoading()
    fun showSurveys(surveys: List<Survey>)
    fun hideLoading()
}

class SurveyPresenter(
    private val view: SurveyView,
    private val repository: SurveyRepository
) {

    fun loadSurveys() {
        view.showLoading()
        view.showSurveys(repository.getSurveys().sortedByDescending { it.name })
        view.hideLoading()
    }
}