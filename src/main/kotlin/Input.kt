interface WebInput

class Instagram: WebInput {

    fun visitProfile(profile: String): InstagramProfile {
        val prof = InstagramProfile(profile)
        activeWorkflow.registerInput()
        return InstagramProfile(profile)
    }

    fun visitProfiles(vararg profiles: String): List<InstagramProfile> {
        return profiles.map { visitProfile(it) }
    }

    class InstagramProfile(val handle: String) {
        // scraping ??
    }

}

val instagram = Instagram()

class Arena: WebInput {

    fun visitChannel(ch: String): ArenaChannel {
        activeWorkflow.registerInput()
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

val are_na = Arena()

class Slack: WebInput {

    fun visitChannel(ch: String): SlackChannel {
        activeWorkflow.registerInput()
        return SlackChannel(ch)
    }

    fun visitChannels(vararg channels: String): List<SlackChannel> {
        return channels.map { channel ->
            visitChannel(channel)
        }
    }

    class SlackChannel(id: String) {
        // scraping?

        fun readLatestMessages() {

        }
    }
}

val slack = Slack()