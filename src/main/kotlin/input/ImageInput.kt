package input

import items.ImageItem
import org.openrndr.draw.ColorBuffer

data class ImageInput(
    val imageItem: ImageItem
): Input() {

}

fun ImageInput.asColorBuffer(): ColorBuffer {
    return imageItem.image
}
