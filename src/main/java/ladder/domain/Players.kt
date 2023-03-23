package ladder.domain

class Players(rawNames: String) {

    val value: List<Player>

    init {
        val names = rawNames.split(",")
        validateNoDuplication(names)
        value = names.map { name: String -> Player(name) }
    }

    private fun validateNoDuplication(names: List<String>) {
        val reducedNames = names.distinct()
        require(names.size == reducedNames.size) { "중복된 이름이 존재하면 안됩니다." }
    }

    fun getPlayerSize(): Int {
        return value.size
    }

    fun getPlayer(index: Int): Player {
        return value[index]
    }
}
