package tools

import Visualizable
import visualizer.Colors
import visualizer.Properties

@Properties(
    Colors.ORANGE_SHADE_1,
    0.3,
    Toolkit::class
)
class Music() : Tool, Visualizable() {

    override val input: Any = "Feeling"
    override val output: Any = "Sound"

    fun play() {

    }

    fun pause() {

    }

    fun stop() {

    }
}
