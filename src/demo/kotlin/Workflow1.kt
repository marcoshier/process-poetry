import input.web.*
import items.ImageItem
import lib.rainbowShadeStyle
import lib.random
import people.people

// openrndr imports
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.viewbox.viewBox
import output.Image
import tools.*
import visualizer.visualizeWorkflow


fun main() {

    application {
        configure {
            width = 1280
            height = 1280
        }
        program {

            val wf1 = Workflow().apply {

                gatherInput {

                    Web().open {

                        instagram.visitProfiles(
                            "andreassygin",
                            "rndrnl",
                            "yewhan_yen_song",
                        )

                        repeat(random(10, 30)) {
                            instagram.visitProfile(people.random())
                        }

                        are_na.visitChannels(
                            "generative art",
                            "creative coding"
                        )

                        slack.visitChannel("random").readLatestMessages()

                    }
                }

                produceOutput { registeredInputs ->

                    openrndr(Image::class) {
                        val selectedInput = registeredInputs.random()
                        if (selectedInput.mediaItems.isNotEmpty()) {
                            val mediaItem = selectedInput.mediaItems.first()

                            if (mediaItem is ImageItem) {
                                drawer.image(mediaItem.image)
                            }

                            perturb()

                            shade(rainbowShadeStyle)

                            attachGUI()
                        }
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

                }
            }


            val vb = viewBox(drawer.bounds) {
                visualizeWorkflow(wf1)
            }

            extend {
                drawer.clear(ColorRGBa.BLACK)

                vb.draw()

            }
        }
    }
}