package tools.ableton

import registry.Visualizable


@Visualizable
interface AbletonSynth {
    fun playNotes(vararg notes: Char) {

    }
}

@Visualizable
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
