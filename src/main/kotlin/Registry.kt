import visualizer.Properties


object ClassRegistry {
    val registeredClasses = mutableSetOf<Class<*>>()

    fun register(instance: Class<*>) {
        registeredClasses.add(instance)
    }
}

abstract class Visualizable {
    init {
        ClassRegistry.register(this.javaClass)
    }
}

fun getProperties(): Map<Class<*>, Annotation> {
    val props =  ClassRegistry.registeredClasses.associate {
        it to it.annotations.toList().first { it is Properties }
    }

    ClassRegistry.registeredClasses.clear()

    return props
}