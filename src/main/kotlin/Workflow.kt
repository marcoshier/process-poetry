import input.Input
import output.Output
import registry.*

class Workflow {

    val allInputs = mutableListOf<Input>()
    val allOutputs = mutableListOf<Output>()

    val inputMetadata = mutableListOf<Metadata<Input>>()
    val outputMetadata = mutableListOf<Metadata<Output>>()

    fun gatherInput(inputCollector: () -> Unit) {
        Registry.isolated {
            inputCollector()

            val metadata = getVisualizerMetadata<Input>()

            inputMetadata.add(
                metadata
            )


            val inputs = getInputs()

            allInputs.addAll(inputs)
        }
    }

    fun produceOutput(outputCollector: (List<Input>) -> Unit) {
        Registry.isolated {
            outputCollector(allInputs)

            val metadata = getVisualizerMetadata<Output>()

            outputMetadata.add(
                metadata
            )

            val outputs = getOutputs()

            outputs.addAll(outputs)
        }
    }


    fun buildGraph() {

    }

}
