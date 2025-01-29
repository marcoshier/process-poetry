package tools.ableton

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import registry.Registrable
import registry.Visualizable
import visualizer.ActionVisualizer
import visualizer.ContinuousVisualizer

fun ableton(block: AbletonInstance.() -> Unit) {
    val abletonInstance = AbletonInstance()

    abletonInstance.run {
        block()
    }

}

@Visualizable
class AbletonInstance: Registrable() {

    var bpm = 120
    val synths = mutableListOf<AbletonSynth>()

    val currentSynth: AbletonSynth
        get() = synths.last()

    var currentInput: AbletonMidi? = null

    @Visualizable(ActionVisualizer::class)
    fun setTempo(bpm: Int) {
        this.bpm = bpm
    }

    @Visualizable(ActionVisualizer::class)
    fun setInput(input: AbletonMidi) {
        currentInput = input
    }

    var recording = false
    var startedRecordingTimestamp = 0L

    @Visualizable(ContinuousVisualizer::class)
    fun startRecording() {
        startedRecordingTimestamp = System.currentTimeMillis()
        recording = true
        runBlocking {
            delay(2000)
            recording = false
        }
    }

    @Visualizable(ActionVisualizer::class)
    fun stopRecording() {

    }

    @Visualizable(ActionVisualizer::class)
    fun <T : AbletonSynth> addSynth(synth: T, configure: (T.() -> Unit)? = null) {
        synth.run {
            if (configure != null) {
                configure()
            }
        }
        synths.add(synth)
    }

}
