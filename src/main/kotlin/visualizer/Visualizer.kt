package visualizer

import Workflow
import org.openrndr.Program
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.RenderTarget

interface Visualizer {

    fun draw(drawer: Drawer) {

    }
}

fun Program.visualizeWorkflow(workflow: Workflow) {

    val root = drawer.bounds.offsetEdges(-20.0)


    RenderTarget.active
    extend {

        drawer.clear(ColorRGBa.GRAY.shade(0.3))

    }
}