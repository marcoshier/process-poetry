import io.Input
import lib.Present
import lib.random
import tools.Web
import tools.WebInputType
import kotlin.concurrent.thread
import kotlin.random.Random
import lib.the
import mind.Worry

fun begins() {

    var suddenInspiration = false
    var letGo = false

    while (!suddenInspiration || letGo) {
        world.sit {
val             idly by the(world::sea)

            idly.run { mind in void

                body.inhale()
                body.exhale()

val             exhaustion = 100
var             worry = 0

                for (attempt in 0 until exhaustion) {
                    try {
                        mind..gone && body is Present

                        if (random(0, 10000) == 10000) {
                            suddenInspiration = true
                        } else worry++
                    } catch (me: Worry) {

                        letGo = true
                        break

                    } } } } }

    if (suddenInspiration) { thread {
            lightly
        } }

    if (letGo) {
        body.sleep
        time.nextDay.listen {
            begins()
        } }
}






val lightly = ""
fun main() {
    begins()
}