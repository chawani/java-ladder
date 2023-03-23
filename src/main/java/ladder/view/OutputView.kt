package ladder.view

import ladder.domain.*
import ladder.dto.PointsTupleDto
import org.apache.commons.lang3.StringUtils

object OutputView {

    private const val PADDING_WIDTH = 5

    fun error(e: Exception) {
        println(e.message)
    }

    fun printLadder(players: Players, rewards: Rewards, ladder: Ladder) {
        println("사다리 결과")
        printNames(players)
        printLadder(ladder)
        printRewards(rewards)
    }

    private fun printNames(players: Players) {
        for (player in players.value) {
            print(StringUtils.center(player.name, PADDING_WIDTH))
        }
    }

    private fun printLadder(ladder: Ladder) {
        println()
        for (line in ladder.lines) {
            printLine(line)
        }
    }

    private fun printLine(line: Line) {
        val points: List<PointsTupleDto> = line.makeTupleDto()

        val sb = StringBuilder()
        sb.append("  |")

        for (point in points) {
            sb.append(printPoint(point.right))
            sb.append("|")
        }

        println(sb.toString())
    }

    private fun printPoint(point: Boolean): String {
        return if (point) {
            "-----"
        } else "     "
    }

    private fun printRewards(rewards: Rewards) {
        for (reward in rewards.value) {
            print(StringUtils.center(reward.value, PADDING_WIDTH))
        }
    }

    fun printResult(pairs: ResultPairs) {
        println()
        while (true) {
            val name = InputView.inputName()
            if (name.lowercase() == "all") {
                printResultAll(pairs)
                break
            }
            checkName(name, pairs)
        }
    }

    private fun printResultAll(pairs: ResultPairs) {
        println("실행 결과")
        println(pairs.print())
    }

    private fun checkName(name: String, pairs: ResultPairs) {
        if (pairs.hasName(name)) {
            printResultPair(pairs.findPlayer(name))
            return
        }
        println("존재하는 이름을 입력해야 합니다.")
    }

    private fun printResultPair(pair: ResultPair) {
        print("실행 결과 : ")
        print(pair.getReward())
    }
}
