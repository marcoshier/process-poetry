package tools

import Visualizable
import body.Body
import registry.Colors
import registry.VisualizerProperties

@VisualizerProperties(
    Colors.ORANGE_SHADE_1_TINT_1,
    0.2,
    Toolkit::class
)
class Web: Tool, Visualizable() {

    override val input: Any = listOf("mouse", "keyboard")
    override val output: Any = listOf("information")

    fun open(action: () -> Unit) {

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
