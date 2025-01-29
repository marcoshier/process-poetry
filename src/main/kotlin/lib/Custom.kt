package lib

import registry.Visualizable
import visualizer.RepeatVisualizer

@Visualizable(RepeatVisualizer::class)
fun _repeat(n: Int, block: (Int) -> Unit) {
    repeat(n, block)
}