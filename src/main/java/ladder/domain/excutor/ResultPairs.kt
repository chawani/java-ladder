package ladder.domain.excutor

import ladder.domain.ladder.Ladder
import ladder.domain.ladder.Line
import ladder.domain.player.Players
import ladder.domain.reward.Rewards

class ResultPairs(
    players: Players,
    rewards: Rewards,
    ladder: Ladder
) {

    private val resultPairs: List<ResultPair>

    init {
        for (line in ladder.lines) {
            goingDownOneLine(players, line)
        }
        resultPairs = players.map { ResultPair(it, rewards[it.index]) }
    }

    private fun goingDownOneLine(players: Players, line: Line) {
        for (player in players) {
            player.move(line.movePointPairs)
        }
    }

    fun searchReward(name: String): String {
        return requireNotNull(resultPairs.find { it.matchName(name) }) { "찾을 수 없는 이름입니다." }
            .getReward()
    }

    fun result(): String {
        val stringBuilder = StringBuilder()
        for (resultPair in resultPairs) {
            stringBuilder.append("{${resultPair.result()}}\n")
        }
        return stringBuilder.toString()
    }
}
