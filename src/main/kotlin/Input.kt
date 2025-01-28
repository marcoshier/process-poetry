fun gatherInput(inputCollector: () -> Unit) {
    inputCollector()
}

interface WebInput

class Instagram: WebInput {

    fun visitProfile(profile: String): InstagramProfile {
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
    }
}

val are_na = Arena()

class Slack(channel: String): WebInput {

    fun visitChannel(vararg profile: String) {

    }
}