package ladder.domain.reward

class Reward(val value: String) {

    init {
        validateRewardsLength(value)
    }

    companion object {

        private const val MAX_LENGTH: Int = 5
        private const val MIN_LENGTH: Int = 1

        private fun validateRewardsLength(reward: String) {
            require(reward.length in MIN_LENGTH..MAX_LENGTH) { "보상은 ${MIN_LENGTH}자 이상 ${MAX_LENGTH}자 이내여야 합니다." }
        }
    }
}
