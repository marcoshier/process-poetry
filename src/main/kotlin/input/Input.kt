package input

import items.MediaItem
import registry.Registerable

abstract class Input: Registerable() {

    val mediaItems = mutableListOf<MediaItem>()


}