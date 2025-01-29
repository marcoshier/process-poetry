package tools

import org.openrndr.Program
import org.openrndr.drawImage
import output.Image
import output.Output
import kotlin.reflect.KClass

fun Program.openrndr(outputType: KClass<out Output>, drawBlock: OpenrndrInstance.() -> Unit) {
    val openrndrInstance = OpenrndrInstance()

    when (outputType) {
        Image::class -> openrndrInstance.drawImage(this, drawBlock)
    }

}


class OpenrndrInstance {

    fun drawImage(program: Program, drawBlock: OpenrndrInstance.() -> Unit) {
        program.drawImage(640, 640) {
            drawBlock()
        }
    }

    fun perturb() {

    }

    fun shade(glsl: String) {

    }

    fun attachGUI() {

    }

}
