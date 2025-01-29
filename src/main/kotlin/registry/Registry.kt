package registry

import input.Input
import output.Output
import kotlin.reflect.KClass

object Registry {
    val registeredClasses = mutableSetOf<KClass<out Registrable>>()

    val registeredInputs = mutableListOf<Input>()
    val registeredOutputs = mutableListOf<Output>()

    fun registerClass(instance: KClass<out Registrable>) {
        registeredClasses.add(instance)
    }

    fun registerInput(instance: Input) {
        println("adding instance $instance")
        registeredInputs.add(instance)
    }

    fun registerOutput(instance: Output) {
        registeredOutputs.add(instance)
    }

    fun clear() {
        registeredClasses.clear()
        registeredInputs.clear()
        registeredOutputs.clear()
    }

}
