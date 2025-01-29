package visualizer

import activeWorkflow
import are_na
import instagram
import slack
import people.people
import tools.Archive
import tools.Web

import getProperties

// openrndr imports
import org.openrndr.Program
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.shapes.grid
import org.openrndr.extra.viewbox.viewBox

fun main() {


    val process1 = activeWorkflow.run {

        gatherInput {

            Web().open {

                instagram.visitProfiles(
                    "andreas_sygin",
                    "rndrnl",
                    "yewhan_yen_song",
                )

                repeat(100) {
                    instagram.visitProfile(people.random())
                }

                are_na.visitChannels(
                    "generative art",
                    "creative coding"
                )

                slack.visitChannel("random").readLatestMessages()
            }

            Archive().open {
                val items = searchItems()

                for (item in items) {
                    if (item.isInteresting) {
                        //Input()
                    }
                }
            }

        }

        produceOutput {

        }

        getProperties()
    }


    val processes = listOf(process1)

    application {
        configure {
            width = 1280
            height = 1280
        }
        program {

            val grid = drawer.bounds.grid(300.0, 300.0, 20.0, 20.0, 20.0).flatten()

            val windows = processes.mapIndexed { i, properties ->
                viewBox(grid[i]) { visualize(properties) }
            }

            extend {
                drawer.clear(ColorRGBa.BLACK)

                windows.forEach {
                    it.draw()
                }
            }
        }
    }
}

fun Program.visualize(props: Map<Class<*>, Annotation>) {

    val root = drawer.bounds.offsetEdges(-20.0)

    extend {

        drawer.clear(ColorRGBa.GRAY.shade(0.3))


        for ((clazz, properties) in props) {

        }

    }
}