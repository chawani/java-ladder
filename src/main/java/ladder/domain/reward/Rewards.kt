package ladder.domain.reward

class Rewards(private val rewards: List<Reward>) : List<Reward> by rewards {

    fun getReward(index: Int): Reward {
        return rewards[index]
    }
}