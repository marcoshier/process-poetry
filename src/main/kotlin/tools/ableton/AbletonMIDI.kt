package tools.ableton
import org.openrndr.Keyboard
import registry.Visualizable

interface AbletonMidi {
    fun listen(input: (Char) -> Unit) {

    }
}

@Visualizable
class Keyboard: AbletonMidi {

    val kb = Keyboard()
    var listening = false

    override fun listen(input: (Char) -> Unit) {
        if (!listening) {
            kb.character.listen {

            }
            listening = true
        }

    }

}
