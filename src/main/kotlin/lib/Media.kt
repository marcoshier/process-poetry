package lib

import kotlin.random.Random

class VideoItem() : MediaItem {
    override val isInteresting = Random.nextBoolean()

    override fun consume() {

    }
}

class ImageItem() : MediaItem {
    override val isInteresting = Random.nextBoolean()

    override fun consume() {

    }

}


interface MediaItem {
    val isInteresting: Boolean

    fun consume()
}