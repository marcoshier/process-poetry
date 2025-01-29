package registry

import visualizer.SquareVisualizer
import visualizer.Visualizer
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS,
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.FUNCTION
)
annotation class Visualizable(
    val visualizer: KClass<out Visualizer> = SquareVisualizer::class
)

@Target(AnnotationTarget.CLASS,
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.LOCAL_VARIABLE
)
annotation class Connect(
    val parent: KClass<out Registrable> = EmptyRegistrable::class,
    val siblings: Array<KClass<out Registrable>> = []
)