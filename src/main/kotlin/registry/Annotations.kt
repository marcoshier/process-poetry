package registry

import visualizer.SquareVisualizer
import visualizer.Visualizer
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS,
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.LOCAL_VARIABLE
)
annotation class VisualizerProperties(
    val weight: Double,
    val visualizer: KClass<out Visualizer> = SquareVisualizer::class
)
