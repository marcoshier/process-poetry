package input.web

val are_na = Arena()

class Arena: WebInput() {

    fun visitChannel(ch: String): ArenaChannel {
        return ArenaChannel().apply {
            channel = ch
        }
    }

    fun visitChannels(vararg channels: String): List<ArenaChannel> {
        return channels.map { channel ->
            visitChannel(channel)
        }
    }

    class ArenaChannel() {
        var channel: String = ""

        // scraping?
    }
}