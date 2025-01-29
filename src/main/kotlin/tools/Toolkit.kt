package tools

import Visualizable
import visualizer.Colors
import visualizer.Properties

@Properties(Colors.ORANGE, 0.4)
class Toolkit: Visualizable() {
    val tools = mutableListOf<Tool>()

    fun add(tool: Tool) {
        tools.add(tool)
    }
}


interface Tool {

    val input: Any
    val output: Any

    fun work() {

    }
}