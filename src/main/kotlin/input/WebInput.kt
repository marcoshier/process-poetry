package input

import items.ImageItem
import registry.Visualizable

/**
    Web input can be web pages, chats, forum/social interactions...
    it can contain media such as images, videos...
 */

@Visualizable
abstract class WebInput: Input() {

    val url = ""
    val images = mutableListOf<ImageInput>()

    fun scrape(imageInput: ImageInput) {
        images.add(imageInput)
    }

}

