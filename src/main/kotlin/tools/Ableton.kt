package tools

import org.openrndr.KeyEvent
import org.openrndr.Keyboard


fun ableton(block: AbletonInstance.() -> Unit) {
    val abletonInstance = AbletonInstance()

    abletonInstance.run {
        block()
    }

}

class AbletonInstance {

    var tempo = 120
    val synths = mutableListOf<AbletonSynth>()

    val currentSynth: AbletonSynth
        get() = synths.last()

    var currentInput: AbletonInput? = null

    fun setTempo(bpm: Int) {
        tempo = bpm
    }

    fun setInput(input: AbletonInput) {
        currentInput = input
    }

    var recording = false
    var startedRecordingTimestamp = 0L

    fun startRecording() {
        startedRecordingTimestamp = System.currentTimeMillis()
        recording = true
    }

    fun stopRecording() {

    }

    fun <T : AbletonSynth> addSynth(synth: T, configure: (T.() -> Unit)? = null) {
        synth.run {
            if (configure != null) {
                configure()
            }
        }
        synths.add(synth)
    }

}

interface AbletonInput {

    fun listen(input: (Char) -> Unit) {

    }

}

class Keyboard(): AbletonInput {

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

interface AbletonSynth {

    fun playNotes(vararg notes: Char) {

    }

}

class Operator: AbletonSynth {

    class OperatorWave(
        var amp: Double,
        var freq: Double,
        var type: WaveType
    )

    enum class WaveType {
        SINE,
        SQUARE,
        SAW,
        TRIANGLE
    }

    val waves = mapOf(
        "a" to null,
        "b" to null,
        "c" to null,
        "d" to OperatorWave(1.0, 1.0, WaveType.SINE)
    )


    fun setWave(id: String, type: WaveType) {
        waves[id]?.type = type
    }

    fun setFrequency(id: String, frequency: Double) {
        waves[id]?.freq = frequency
    }

    fun setAmplitude(id: String, amp: Double) {
        waves[id]?.amp = amp
    }

}
