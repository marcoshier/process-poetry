package tools

import output.ImageOutput
import registry.Registrable
import registry.Visualizable

fun web(block: () -> Unit) {
    val webInstance = WebInstance()

    webInstance.run {
        block()
    }
}

@Visualizable
class WebInstance: Registrable() {

    val imageOutputs = mutableListOf<ImageOutput>()

}