package body

class Listener(private val type: String) {
    private val data = mutableListOf<Any>()

    fun append(item: Any) {
        data.add(item)
    }
}