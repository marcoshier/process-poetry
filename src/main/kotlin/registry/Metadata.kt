package registry

import input.Input
import output.Output
import kotlin.reflect.KClass


data class Metadata <out T>(
    val visualizables: Map<KClass<out Registrable>, Visualizable?>,
    val connections: Map<KClass<out Registrable>, Visualizable> = mapOf()
)

fun <T> getVisualizerMetadata(): Metadata<T> {
    val properties = Registry.getVisualData()

    return Metadata(properties)
}

fun getInputs(): MutableList<Input> {
    return Registry.registeredInputs
}

fun getOutputs(): MutableList<Output> {
    return Registry.registeredOutputs
}
