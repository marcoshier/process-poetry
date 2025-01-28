package tools

import Visualizable
import body.Body
import visualizer.Colors
import visualizer.Properties
import kotlin.random.Random

@Properties(
    Colors.ORANGE_SHADE_1_TINT_1,
    0.2,
    Toolkit::class
)
class Web: Tool, Visualizable() {

    override val input: Any = listOf("mouse", "keyboard")
    override val output: Any = listOf("information")

    fun open(vararg input: WebInput) {

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
