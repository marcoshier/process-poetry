package registry

import input.Input
import output.Output
import kotlin.reflect.KClass


data class Metadata <out T>(
    val properties: Map<KClass<out Registrable>, Annotation?>
)

fun  <T> getMetadata(): Metadata<T> {
    val properties = Registry.getVisualData()

    return Metadata(properties)
}

fun getInputs(): MutableList<Input> {
    return Registry.registeredInputs
}

fun getOutputs(): MutableList<Output> {
    return Registry.registeredOutputs
}
