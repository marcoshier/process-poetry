package tools

import items.ImageItem
import items.MediaItem
import items.VideoItem
import org.openrndr.extra.noise.uniform

class Archive() {

    val items = mutableListOf<MediaItem>()

    fun open(action: Archive.() -> Unit) {

    }

    fun searchItems(): List<MediaItem> {
        return (0..Int.uniform(50, 100)).map {
            val r = Double.uniform(0.0, 1.0)
            if (r > 0.5) {
                VideoItem()
            } else {
                ImageItem()
            }
        }
    }

}
