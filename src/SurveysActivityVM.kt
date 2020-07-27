class SurveysActivityVM {

    private val viewModel = SurveyViewModel(
        repository = SurveyRepository()
    )

    fun onCreate() {
        viewModel.surveyState.observe { state ->
            when(state) {
                State.Loading -> println("loading")
                State.SurveySubmitted -> println("submitted")
                State.SurveyDeleted -> println("deleted")
                is State.SurveysLoaded -> {
                    println(state.surveys)
                }
            }
        }

        viewModel.onAction(Action.LoadSurveys)
        viewModel.onAction(Action.SubmitSurvey)
        viewModel.onAction(Action.DeleteSurvey)
    }
}