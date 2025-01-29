package visualizer

import org.openrndr.color.ColorRGBa
import kotlin.reflect.KClass

enum class Colors(val color: ColorRGBa) {
    LIGHT_GREEN(ColorRGBa.fromHex("#DDFF00")),
    LILIAC(ColorRGBa.fromHex("#EBBEFF")),
    PURPLE(ColorRGBa.fromHex("#675FE1")),
    ORANGE(ColorRGBa.fromHex("#EBBEFF")),
    ORANGE_SHADE_1(ColorRGBa.fromHex("#EF8021")),
    ORANGE_SHADE_1_TINT_1(ColorRGBa.fromHex("#EFEF21")),
    ORANGE_SHADE_1_TINT_2(ColorRGBa.fromHex("#C55B00")),
    PINK(ColorRGBa.PINK),
    TRANSPARENT(ColorRGBa.TRANSPARENT),
}

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS,
    AnnotationTarget.LOCAL_VARIABLE)
annotation class Properties(
    val highlightColor: Colors ,
    val relativeSize: Double,
    val parent: KClass<*> = Nothing::class,
    val connections: Array<KClass<*>> = []
)
