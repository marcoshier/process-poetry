package tools.web

import input.ImageInput
import input.WebInput
import items.ImageItem
import registry.Visualizable
import visualizer.ActionVisualizer
import visualizer.ContinuousVisualizer

@Visualizable
class Instagram: WebInput() {

    @Visualizable(ContinuousVisualizer::class)
    fun visitProfile(profile: String): InstagramProfile {
        return InstagramProfile(profile)
    }

    @Visualizable(ActionVisualizer::class)
    fun visitProfiles(vararg profiles: String): List<InstagramProfile> {
        return profiles.map { visitProfile(it) }
    }

    @Visualizable
    inner class InstagramProfile(val handle: String) {
        // scraping ??

        fun loadImages() {
            scrape(
                ImageInput(
                    ImageItem("data/images/image.png")
                )
            )
        }
    }

}