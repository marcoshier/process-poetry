package tools

import org.openrndr.Program
import visualizer.Colors
import visualizer.Properties

@Properties(
    Colors.PINK,
    0.35,
    Toolkit::class
)
class OpenRNDR {
    fun program(block: Program.() -> Unit): Application {
        return Application(block)
    }
}

class Application(private val block: Program.() -> Unit) {
    fun extend(extendBlock: () -> Unit) {
        // Simulate OpenRNDR extension
    }
}