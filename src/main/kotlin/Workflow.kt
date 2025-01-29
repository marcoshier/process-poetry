import io.Input
import lib.MediaItem

class Workflow() {

    val input = mutableListOf<Input>()
    val output = mutableListOf<Output>()

    fun gatherInput(inputCollector: () -> Unit) {
        inputCollector()
    }

    fun produceOutput(outputCollector: () -> Unit) {
        outputCollector()
    }

}

val activeWorkflow = Workflow()