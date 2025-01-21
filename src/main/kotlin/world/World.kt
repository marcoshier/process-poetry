package world

import body.Body
import body.Listener

class World {
    val weather: Weather = Weather()
    val friends: Friends = Friends()
    val listeners = mutableMapOf<String, Listener>()

    fun addListener(type: String) {
        listeners[type] = Listener(type)
    }

    fun locationOf(entity: Any): Location = when(entity) {
        is Body -> Location.HOUSE  // Default location
        else -> Location.UNKNOWN
    }

    operator fun get(key: String): Listener? = listeners[key]
}