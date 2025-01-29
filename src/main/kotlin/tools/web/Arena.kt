package tools.web

import input.WebInput
import registry.Visualizable
import visualizer.ActionVisualizer
import visualizer.ContinuousVisualizer

@Visualizable
class Arena: WebInput() {

    @Visualizable(ContinuousVisualizer::class)
    fun visitChannel(ch: String): ArenaChannel {
        return ArenaChannel().apply {
            channel = ch
        }
    }

    @Visualizable(ActionVisualizer::class)
    fun visitChannels(vararg channels: String): List<ArenaChannel> {
        return channels.map { channel ->
            visitChannel(channel)
        }
    }

    @Visualizable
    class ArenaChannel() {
        var channel: String = ""

        // scraping?
    }
}