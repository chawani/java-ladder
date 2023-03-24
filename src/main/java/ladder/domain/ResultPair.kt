package ladder.domain

class ResultPair(private val player: Player, private val reward: Reward) {

    fun matchName(name: String): Boolean = player.name == name

    fun getReward(): String = reward.value

    fun print(): String {
        return "${player.name}:${reward.value}"
    }
}
