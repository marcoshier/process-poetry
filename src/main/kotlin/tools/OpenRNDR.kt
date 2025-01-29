package tools

import org.openrndr.Program
import org.openrndr.draw.ColorBuffer
import org.openrndr.drawImage
import output.ImageOutput
import output.Output
import output.toImageOutput
import registry.Registrable
import registry.Visualizable
import visualizer.ActionVisualizer
import visualizer.DrawVisualizer
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : Output> Program.openrndr(outputType: KClass<T>, drawBlock: OpenrndrInstance.() -> Unit): T {
    val openrndrInstance = OpenrndrInstance()

    return when (outputType) {
        ImageOutput::class -> {
            val image = openrndrInstance.drawImage(this, drawBlock)
            image.toImageOutput() as T
        }
        else -> ImageOutput("") as T
    }
}


@Visualizable
class OpenrndrInstance: Registrable() {

    @Visualizable(DrawVisualizer::class)
    fun drawImage(program: Program, drawBlock: OpenrndrInstance.() -> Unit): ColorBuffer {
        return program.drawImage(640, 640) {
            drawBlock()
        }
    }

    @Visualizable(ActionVisualizer::class)
    fun ColorBuffer.perturb(
        scale: Double = 1.0,
        frequency: Double = 2.0,
        amp: Double = 1.0
    ): ColorBuffer {
        return this // hehe
    }

    @Visualizable(ActionVisualizer::class)
    fun ColorBuffer.shade(program: Program, glsl: String) {

    }

    fun attachGUI() {
        // TODO
    }

}
