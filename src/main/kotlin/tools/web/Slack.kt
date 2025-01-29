package tools.web

import input.WebInput


class Slack: WebInput() {

    fun visitChannel(ch: String): SlackChannel {
        return SlackChannel(ch)
    }

    fun visitChannels(vararg channels: String): List<SlackChannel> {
        return channels.map { channel ->
            visitChannel(channel)
        }
    }

    class SlackChannel(id: String) {
        // scraping?

        fun readLatestMessages(): List<String> {
            return listOf("")
        }
    }


}