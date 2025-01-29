package registry

import input.Input
import output.Output
import kotlin.reflect.KClass

object Registry {
    val registeredClasses = mutableSetOf<KClass<out Registerable>>()

    val registeredInput = mutableListOf<Input>()
    val registeredOutput = mutableListOf<Output>()

    fun registerClass(instance: KClass<out Registerable>) {
        registeredClasses.add(instance)
    }

    fun registerInput(instance: Input) {
        registeredInput.add(instance)
    }

    fun registerOutput(instance: Output) {
        registeredOutput.add(instance)
    }

    fun clear() {
        registeredClasses.clear()
        registeredInput.clear()
        registeredOutput.clear()
    }

}
