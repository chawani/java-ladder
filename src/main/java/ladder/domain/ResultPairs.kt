package ladder.domain

class ResultPairs(players: Players, rewards: Rewards, index: ResultIndex) {

    private val pairs: List<ResultPair>

    init {
        pairs = index.resultIndex.map {
            ResultPair(players.getPlayer(index.findIndex(it)), rewards.getReward(it))
        }
    }

    fun hasName(name: String): Boolean {
        return pairs.stream().anyMatch { it.matchName(name) }
    }

    fun findPlayer(name: String): ResultPair {
        return pairs.stream().filter { it.matchName(name) }.findAny().orElseThrow { IllegalArgumentException("에러") }
    }

    fun print(): String {
        val stringBuilder = StringBuilder()
        for (pair in pairs) {
            stringBuilder.append("{${pair.print()}}\n")
        }
        return stringBuilder.toString()
    }
}
