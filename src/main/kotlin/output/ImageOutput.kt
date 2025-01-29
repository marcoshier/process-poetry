package output

import org.openrndr.draw.ColorBuffer

class ImageOutput(
    val base64: String
): Output()


fun ColorBuffer.toImageOutput(): ImageOutput {
    return ImageOutput(this.toDataUrl())
}