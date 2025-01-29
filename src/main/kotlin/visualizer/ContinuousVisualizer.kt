package visualizer

import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.math.mod
import org.openrndr.shape.Circle

class ContinuousVisualizer: Visualizer {

    override fun draw(drawer: Drawer) {
        val t = System.currentTimeMillis() / 1000.0
        drawer.stroke = ColorRGBa.BLACK
        drawer.fill = null
        val c = Circle(0.0, 0.0, 250.0)

        drawer.contour(
            c.contour.sub(t * 0.2, t * 0.2 + 0.5)
        )
    }
}