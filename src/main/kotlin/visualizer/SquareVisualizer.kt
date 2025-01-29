package visualizer

import org.openrndr.draw.Drawer

class SquareVisualizer: Visualizer {

    override fun draw(drawer: Drawer) {
        drawer.rectangle(0.0, 0.0, 100.0, 100.0)
    }
}