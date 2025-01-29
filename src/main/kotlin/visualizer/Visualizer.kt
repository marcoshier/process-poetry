package visualizer

import Workflow
import org.openrndr.Program
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.draw.RenderTarget
import org.openrndr.extra.camera.Camera2D
import org.openrndr.extra.shapes.grid

interface Visualizer {

    fun draw(drawer: Drawer) {

    }

}

fun Program.visualizeWorkflow(workflow: Workflow) {

    val root = drawer.bounds.offsetEdges(-100.0)

    val grid = drawer.bounds.grid(5, 5).flatten()

    extend(Camera2D())
    extend {

        for ((i, m) in workflow.inputMetadata.withIndex()) {

            drawer.stroke = ColorRGBa.WHITE
            drawer.fill = ColorRGBa.BLACK

            val r = grid[i]
            drawer.rectangle(r)

            drawer.fill = ColorRGBa.WHITE
            //drawer.text(m.visualizables)


        }

        workflow.inputMetadata



    }
}