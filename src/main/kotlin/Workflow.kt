import input.Input
import output.Output
import registry.Registry
import registry.getMetadata
import registry.isolated
import registry.Metadata

class Workflow {

    val inputMetadata = mutableListOf<Metadata<Input>>()
    val outputMetadata = mutableListOf<Metadata<Output>>()

    fun gatherInput(inputCollector: () -> Unit) {
        Registry.isolated {
            inputCollector()

            val metadata = getMetadata<Input>()

            inputMetadata.add(
                metadata
            )
        }
    }

    fun produceOutput(outputCollector: (List<Input>) -> Unit) {
        Registry.isolated {
            outputCollector(Registry.registeredInput)

            val metadata = getMetadata<Output>()

            outputMetadata.add(
                metadata
            )
        }
    }

}
