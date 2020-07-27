class SurveyViewModel(
    private val repository: SurveyRepository
) {
//
//    val loading = Observable<Boolean>()
//    val surveys = Observable<List<Survey>>()
//
//    fun loadSurveys() {
//        loading.value = true
//        surveys.value = repository.getSurveys().sortedByDescending { it.name }
//        loading.value = false
//    }

    val surveyState = Observable<State>()

    fun onAction(action: Action) {
        when(action) {
            Action.LoadSurveys -> loadSurveys()
            Action.SubmitSurvey -> submitSurvey()
            Action.DeleteSurvey -> deleteSurvey()
        }
    }

    private fun loadSurveys() {
        surveyState.value = State.Loading
        surveyState.value = State.SurveysLoaded(repository.getSurveys())
    }

    private fun submitSurvey() {
        surveyState.value = State.Loading
        surveyState.value = State.SurveySubmitted
    }

    private fun deleteSurvey() {
        surveyState.value = State.Loading
        surveyState.value = State.SurveyDeleted
    }
}

sealed class Action {
    object LoadSurveys : Action()
    object SubmitSurvey : Action()
    object DeleteSurvey : Action()
}

sealed class State {
    object Loading : State()
    data class SurveysLoaded(val surveys: List<Survey>) : State()
    object SurveySubmitted : State()
    object SurveyDeleted : State()
}