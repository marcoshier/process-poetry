package registry

import kotlin.reflect.KClass

fun Registry.isolated(block: () -> Unit) {
    clear()
    block()
    clear()
}

fun Registry.getVisualData(): Map<KClass<out Registrable>, Annotation?> {
    val props = registeredClasses.associateWith {
        it.annotations.toList().firstOrNull { it is Visualizable }
    }

    registeredClasses.clear()

    return props
}