package registry

import input.Input
import output.Output

abstract class Registerable {

    init {
        register()
    }

    private fun register() {
        Registry.registerClass(this::class)

        if (this::class is Input) {
            Registry.registerInput(this as Input)
        }

        if (this::class is Output) {
            Registry.registerOutput(this as Output)
        }
    }

}