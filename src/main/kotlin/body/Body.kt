package body

import lib.Present
import world.Friend
import kotlin.random.Random

class Body: Present {
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
