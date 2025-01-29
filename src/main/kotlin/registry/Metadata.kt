package registry

import kotlin.reflect.KClass


data class Metadata <out T>(
    val properties: Map<KClass<out Registerable>, Annotation>
)

fun  <T> getMetadata(): Metadata<T> {
    val properties = Registry.getVisualizerProperties()

    return Metadata(properties)
}
