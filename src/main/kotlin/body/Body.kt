package body

import world.Friend
import kotlin.random.Random

class Body {
    val healthLevel: Double = Random.nextDouble(0.0, 1.0)

    val sleep = Sleep()

    var overwhelmed: Boolean = false

    fun talk(friend: Friend): Conversation {
        return Conversation(Random.nextDouble(0.5, 2.0))
    }

    inner class Sleep {
        val hoursRequired: Double = Random.nextDouble(6.0, 9.0)

    }
}
