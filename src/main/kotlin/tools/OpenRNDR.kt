package tools

import org.openrndr.Program

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