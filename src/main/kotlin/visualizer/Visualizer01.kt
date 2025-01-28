package visualizer

import Instagram
import Slack
import are_na
import gatherInput
import getProperties
import instagram
import org.openrndr.Program
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.shapes.grid
import org.openrndr.extra.viewbox.viewBox
import org.openrndr.shape.Rectangle
import people.people
import tools.Web

fun main() {


    val process1 = run {

        gatherInput {

            Web().open(

                instagram.visitProfiles(
                    "andreas_sygin",
                    "rndrnl",
                    "yewhan_yen_song",
                ),

                repeat(100) {
                    instagram.visitProfile(people.random())
                },

                are_na,
                Slack("openrndr"),
                Slack("rndr"),
            )

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