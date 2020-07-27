typealias Callback<T> = ((T) -> Unit)

class Observable<T> {

    var value: T? = null
        set(value) {
            notifyObservers(value)
        }

    private val observers = mutableListOf<Callback<T>>()

    fun observe(callback: Callback<T>) {
        observers.add(callback)
    }

    private fun notifyObservers(value: T?) {
        if (value == null) {
            return
        }

        observers.forEach {
            it.invoke(value)
        }
    }
}