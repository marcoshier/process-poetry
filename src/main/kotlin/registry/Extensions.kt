package registry

import kotlin.reflect.KClass

fun Registry.isolated(block: () -> Unit) {
    clear()
    block()
    clear()
}

fun Registry.getVisualizerProperties(): Map<KClass<out Registerable>, Annotation> {
    val props = registeredClasses.associateWith {
        it.annotations.toList().first { it is VisualizerProperties }
    }

    registeredClasses.clear()

    return props
}