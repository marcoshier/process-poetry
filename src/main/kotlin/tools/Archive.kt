package tools

class Archive() {

    val items = mutableListOf<ArchiveItem>()


}

interface ArchiveItem {
    fun consume()
}