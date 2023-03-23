package ladder.domain

class Player(val name: String) {

    init {
        validateNameIsAll(name)
        validateNameLength(name)
    }

    private fun validateNameIsAll(name: String) {
        require(name.lowercase() != ALL) { "이름은 " + ALL + "일 수 없습니다." }
    }

    private fun validateNameLength(name: String) {
        require(!(name.length > MAX_NAME_LENGTH || name.length < MIN_NAME_LENGTH)) { "이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이내여야 합니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Player) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        private const val ALL = "all"
        const val MAX_NAME_LENGTH = 5
        const val MIN_NAME_LENGTH = 1
    }
}
