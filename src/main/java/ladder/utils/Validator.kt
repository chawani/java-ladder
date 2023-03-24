package ladder.utils

object Validator {

    private const val REVERSED_WORD = "all"
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_NAME_LENGTH = 1

    fun validNames(names: List<String>) {
        validDuplicate(names)
        for (name in names) {
            validateNameIsAll(name)
            validateNameLength(name)
        }
    }

    fun validatePlayerAndRewardCount(playerCount: Int, rewardCount: Int) {
        require(playerCount == rewardCount) { "플레이어의 이름과 같은 갯수의 보상을 입력해주세요." }
    }

    fun validateNaturalNumber(number: Int) {
        require(number >= 1) { "입력 값은 최소 1 이어야 합니다." }
    }

    private fun validDuplicate(names: List<String>) {
        val reducedNames = names.distinct()
        require(names.size == reducedNames.size) { "중복된 이름이 존재하면 안됩니다." }
    }

    private fun validateNameIsAll(name: String) {
        require(name.lowercase() != REVERSED_WORD) { "이름은 ${REVERSED_WORD}일 수 없습니다." }
    }

    private fun validateNameLength(name: String) {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { "이름은 ${MIN_NAME_LENGTH}자 이상 ${MAX_NAME_LENGTH}자 이내여야 합니다." }
    }
}
