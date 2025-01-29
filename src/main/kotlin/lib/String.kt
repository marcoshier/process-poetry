package lib

import registry.Visualizable
import visualizer.FilterVisualizer

@Visualizable(FilterVisualizer::class)
fun String.containsCode(): Boolean {
    return true
}