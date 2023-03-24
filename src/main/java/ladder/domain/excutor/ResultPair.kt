package ladder.domain.excutor

import ladder.domain.reward.Reward
import ladder.domain.player.Player

class ResultPair(private val player: Player, private val reward: Reward) {

    fun matchName(name: String): Boolean = player.name == name

    fun getReward(): String = reward.value

    fun print(): String {
        return "${player.name}:${reward.value}"
    }
}
