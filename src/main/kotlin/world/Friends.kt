package world

class Friend(val name: String)

class Friends {
    val availableToday: List<Friend> = listOf(Friend("John"), Friend("Jane"))
}