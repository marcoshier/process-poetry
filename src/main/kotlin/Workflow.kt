import input.Input
import output.Output
import registry.*

class Workflow {

    val allInputs = mutableListOf<Input>()
    val allOutputs = mutableListOf<Input>()

    val inputMetadata = mutableListOf<Metadata<Input>>()
    val outputMetadata = mutableListOf<Metadata<Output>>()

    fun gatherInput(inputCollector: () -> Unit) {
        Registry.isolated {
            inputCollector()

            val metadata = getMetadata<Input>()

            println(metadata)

            val inputs = getInputs()

            println(inputs)

            inputMetadata.add(
                metadata
            )

            allInputs.addAll(inputs)
        }
    }

    fun produceOutput(outputCollector: (List<Input>) -> Unit) {
        Registry.isolated {
            outputCollector(allInputs)

            val metadata = getMetadata<Output>()
            val outputs = getOutputs()

            outputMetadata.add(
                metadata
            )

            outputs.addAll(outputs)
        }
    }

}
