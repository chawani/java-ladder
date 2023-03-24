package ladder.domain

class ResultPairs(
    players: Players,
    private val rewards: Rewards,
    val ladder: Ladder
) {

    private val resultPairs: List<ResultPair>

    init {
        for (line in ladder.lines) {
            goingDownOneLine(players, line)
        }
        resultPairs = players.map { ResultPair(it, rewards.getReward(it.index)) }
    }

    private fun goingDownOneLine(players: Players, line: Line) {
        for (player in players) {
            player.move(line.movePointPairs)
        }
    }

    fun findPlayer(name: String): ResultPair {
        return requireNotNull(resultPairs.find { it.matchName(name) }) { "찾을 수 없는 이름입니다." }
    }

    fun print(): String {
        val stringBuilder = StringBuilder()
        for (pair in resultPairs) {
            stringBuilder.append("{${pair.print()}}\n")
        }
        return stringBuilder.toString()
    }
}
