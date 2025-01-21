package tools

import body.Body
import time
import kotlin.random.Random

class Web: Tool {

    override val input: Any = listOf("mouse", "keyboard")
    override val output: Any = listOf("information")

    val rabbitHoles = mutableMapOf<String, List<Webpage>>()

    fun createRabbitHole() {
        val today = time.today
        rabbitHoles[today] = generateWebpages()
    }

    private fun generateWebpages(): List<Webpage> {
        return List(Random.nextInt(5, 20)) {
            Webpage(
                existentialDoomFactor = Random.nextDouble(),
                type = if (Random.nextBoolean()) WebInputType.NEWS else WebInputType.OTHER
            )
        }
    }

    operator fun get(day: String): List<Webpage> = rabbitHoles[day] ?: emptyList()


    // Error handling system
    open class Error : Throwable() {
        var value = ""


    }

}


class Webpage(
    val existentialDoomFactor: Double,
    private val type: WebInputType
) {
    var inputType: WebInputType = WebInputType.OTHER

    fun read(body: Body) {
        // Simulated webpage reading
    }

    fun findInputs() {
        inputType = type
    }

    fun close() {
        // Cleanup resources
    }
}

enum class WebInputType {
    NEWS, OTHER
}
