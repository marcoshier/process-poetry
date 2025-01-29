package items

import org.openrndr.draw.ColorBuffer
import org.openrndr.draw.ColorBufferProxy
import org.openrndr.internal.colorBufferLoader
import java.io.File
import kotlin.random.Random

class VideoItem() : MediaItem {
    val path: String = ""
}

val defaultImage by lazy {
    ColorBuffer.fromFile(File("data/images/image.png"))
}

class ImageItem() : MediaItem {
    val path: String = ""

    private val imageProxy: ColorBufferProxy = colorBufferLoader.loadFromUrl(path)
    val image: ColorBuffer
        get() {
            imageProxy.touch()
            return imageProxy.colorBuffer ?: defaultImage
        }
}

interface MediaItem {

}