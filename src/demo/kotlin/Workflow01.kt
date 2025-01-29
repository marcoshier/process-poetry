import input.WebInput
import input.asColorBuffer
import lib._repeat
import lib.containsCode
import lib.rainbowShadeStyle
import lib.random
import people.people

// openrndr imports
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extra.viewbox.viewBox
import output.ImageOutput
import output.InteractiveOutput
import tools.*
import tools.ableton.Keyboard
import tools.ableton.Operator
import tools.ableton.ableton
import tools.web.Arena
import tools.web.Instagram
import tools.web.Slack
import visualizer.visualizeWorkflow
import kotlin.math.cos
import kotlin.math.sin


fun main() {

    application {
        configure {
            width = 1280
            height = 1280
        }
        program {

            val wf1 = Workflow().apply {

                gatherInput {

                    web {

                        val instagram = Instagram()

                        instagram.visitProfiles(
                            "andreassygin",
                            "rndrnl",
                            "yewhan_yen_song",
                        ).forEach {
                            it.loadImages()
                        }

                        _repeat(random(10, 30)) {
                            instagram.visitProfile(people.random())
                        }

                        Arena().visitChannels(
                            "generative art",
                            "creative coding"
                        )

                        Slack().visitChannel(
                            "random"
                        ).readLatestMessages().filter {
                            it.containsCode()
                        }

                    }

                }

                produceOutput { inputs ->
                    println(inputs)

                    val sketch = openrndr(ImageOutput::class) {

                        val webInputs = inputs.filterIsInstance<WebInput>()
                        val randomWebInput = webInputs.first()

                        println(webInputs.map { it.images })

                        val image = randomWebInput.images.first()

                        drawer.image(image.asColorBuffer())
                    }


                    ableton {
                        setTempo(140)

                        addSynth(Operator()) {
                            setWave("a", Operator.WaveType.SAW)
                            setAmplitude("a", 0.5)
                            setFrequency("a", 4_000.0)

                            setWave("b", Operator.WaveType.TRIANGLE)
                            setAmplitude("b", 0.2)

                            setWave("c", Operator.WaveType.SQUARE)
                        }

                        setInput(Keyboard())
                        startRecording()

                        while (recording) {
                            currentInput?.listen { character ->
                                currentSynth.playNotes(character)
                            }
                        }

                        stopRecording()

                    }


                    openrndr(InteractiveOutput::class) {
                        val image = loadImage(sketch.base64)

                        val perturbed = image.perturb(
                            scale = cos(seconds) * 0.5 + 0.5,
                            frequency = sin(seconds * 0.5),
                            amp = mouse.position.x / width
                        )

                        perturbed.shade(this@program, rainbowShadeStyle)
                    }

                }
            }


            val visualizer = viewBox(drawer.bounds) {
                visualizeWorkflow(wf1)
            }

            extend {
                drawer.clear(ColorRGBa.BLACK)

                visualizer.draw()

            }
        }
    }
}