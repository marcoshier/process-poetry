package visualizer

import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.math.mod

class ActionVisualizer: Visualizer {

    override fun draw(drawer: Drawer) {
        val t = System.currentTimeMillis() / 1000.0
        drawer.stroke = ColorRGBa.BLACK
        drawer.fill = null
        drawer.circle(0.0, 0.0, 200.0 * (1.0 - mod(t, 1.0)))
    }
}