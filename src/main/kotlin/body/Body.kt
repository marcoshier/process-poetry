package body

import Visualizable
import lib.Present
import visualizer.Colors
import visualizer.Properties
import world.Friend
import kotlin.random.Random

@Properties(
    Colors.PURPLE,
    0.5
)
class Body: Present, Visualizable() {
    val healthLevel: Double = Random.nextDouble(0.0, 1.0)

    val sleep = Sleep()

    var overwhelmed: Boolean = false

    fun talk(friend: Friend): Conversation {
        return Conversation(Random.nextDouble(0.5, 2.0))
    }

    fun inhale() {

    }

    fun exhale() {

    }

    inner class Sleep {
        val hoursRequired: Double = Random.nextDouble(6.0, 9.0)

    }
}
