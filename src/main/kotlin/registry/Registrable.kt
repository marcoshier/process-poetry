package registry

import input.Input
import output.Output

abstract class Registrable {

    init {
        register()
    }

    private fun register() {
        Registry.registerClass(this::class)

        if (this is Input) {
            Registry.registerInput(this)
        }

        if (this is Output) {
            Registry.registerOutput(this)
        }
    }
}

class EmptyRegistrable: Registrable()