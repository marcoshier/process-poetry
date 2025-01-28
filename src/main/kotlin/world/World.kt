package world

import Visualizable
import body.Body
import body.Listener
import visualizer.Colors
import visualizer.Properties

@Properties(
    Colors.LIGHT_GREEN,
    1.0
)
class World: Visualizable() {
    val weather: Weather = Weather()
    val friends: Friends = Friends()
    val listeners = mutableMapOf<String, Listener>()

    val sea = ""

    fun addListener(type: String) {
        listeners[type] = Listener(type)
    }

    fun locationOf(entity: Any): Location = when(entity) {
        is Body -> Location.HOUSE  // Default location
        else -> Location.UNKNOWN
    }

    fun sit(how: () -> Unit) {

    }

    operator fun get(key: String): Listener? = listeners[key]
}