package ladder.domain

class Reward(val value: String) {

    init {
        validateRewardsLength(value)
    }

    companion object {
        private val MAX_REWARD_LENGTH: Int = Player.MAX_NAME_LENGTH
        private val MIN_REWARD_LENGTH: Int = Player.MIN_NAME_LENGTH
        private fun validateRewardsLength(reward: String) {
            require(!(reward.length > MAX_REWARD_LENGTH || reward.length < MIN_REWARD_LENGTH)) { "보상은 " + MIN_REWARD_LENGTH + "자 이상 " + MAX_REWARD_LENGTH + "자 이내여야 합니다." }
        }
    }
}
