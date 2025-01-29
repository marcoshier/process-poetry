package registry

import kotlin.reflect.KClass

fun Registry.isolated(block: () -> Unit) {
    clear()
    block()
    clear()
}

fun Registry.getVisualData(): Map<KClass<out Registrable>, Visualizable?> {
    val props = registeredClasses.associateWith {
        it.annotations.toList().filterIsInstance<Visualizable>().firstOrNull() ////
    }

    registeredClasses.clear()

    return props
}