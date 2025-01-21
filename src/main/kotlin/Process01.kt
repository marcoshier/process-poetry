import io.Input
import tools.Web
import tools.WebInputType
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {

    val inputList = mutableListOf<Input>()

    world.addListener("visual")
    world.addListener("audio")

    var energyK = (time.daysOfTheWeek.indexOf(time.today) * 0.33 +
            world.weather.sunAmount * 0.33 +
            body.healthLevel * 0.2 +
            Math.random()) / 4

    if (energyK > 0.5) {
        thread {
            tools.music.play()
            world.listeners["audio"]?.append(tools.music.output)
        }
    }

    var enoughInput = false
    var freeTime = 60.0 * (24.0 - time.workHours - body.sleep.hoursRequired)

    // gather input
    while (enoughInput || (inputList.size <= Random.nextInt(1, 100) * energyK && freeTime > 0.0)) {

        val input = Input()

        input.build {
            for (friend in world.friends.availableToday) {
                val conversation = body.talk(friend)

                if (body.overwhelmed) {
                    enoughInput = true
                }

                freeTime -= conversation.duration
            }

            tools.web.createRabbitHole()

            for (webpage in tools.web.rabbitHoles.getValue(time.today)) {
                try {
                    webpage.read(body)
                    webpage.findInputs()

                    if (webpage.inputType == WebInputType.NEWS) {
                        if (webpage.existentialDoomFactor > 0.5) {
                            energyK -= 0.1
                            webpage.close()
                        }
                    }
                } catch (e: Web.Error) {
                    if (e.value == "NothingToSeeHere") {
                        break
                    }
                }
            }

            val nIterations = (Math.random() * 30).toInt()

            if(energyK > 0.3) {
                for (iteration in 0..nIterations) {
                    val openrndr = tools.openrndr
                    openrndr.program {
                        extend {

                        }
                    }
                }
            }

        }

    }

}


