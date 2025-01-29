package input.web

val instagram = Instagram()

class Instagram: WebInput() {

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