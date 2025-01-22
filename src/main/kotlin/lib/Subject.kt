package lib

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

fun the(
    property: KProperty0<String>
): The {
    return The(property)
}

class The(subject: Any) {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        return ""
    }
}