package mind

import Visualizable
import visualizer.Colors
import visualizer.Properties

@Properties(
    Colors.LILIAC,
    0.3
)
class Mind: Visualizable() {

    operator fun rangeTo(other: Any): Boolean {
       return true
    }

}

class Worry: Throwable()