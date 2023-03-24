package ladder.domain.excutor

import ladder.domain.player.Player
import ladder.domain.reward.Reward

class ResultPair(
    private val player: Player,
    private val reward: Reward
) {

    fun matchName(name: String): Boolean = player.name == name

    fun getReward(): String = reward.value

    fun result(): String {
        return "${player.name}:${reward.value}"
    }
}
