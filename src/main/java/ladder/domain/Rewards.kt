package ladder.domain

class Rewards(rawRewards: String) {

    val value: List<Reward>

    init {
        value = rawRewards.split(",").map { Reward(it) }
    }

    fun getReward(index: Int): Reward {
        return value[index]
    }

    fun getRewardSize(): Int {
        return value.size
    }
}
