package ladder.view

import ladder.domain.excutor.ResultPairs
import ladder.domain.ladder.Ladder
import ladder.domain.ladder.Line
import ladder.domain.player.Players
import ladder.domain.reward.Rewards
import org.apache.commons.lang3.StringUtils

object OutputView {

    private const val PADDING_WIDTH = 6

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
        for (player in players) {
            print(StringUtils.center(player.name, PADDING_WIDTH))
        }
        println()
    }

    private fun printLadder(ladder: Ladder) {
        for (line in ladder.lines) {
            printLine(line)
        }
    }

    private fun printLine(line: Line) {
        val points: List<Boolean> = line.moveJudgments()

        val sb = StringBuilder()
        sb.append("  |")

        for (point in points) {
            sb.append(printPoint(point))
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
        for (reward in rewards) {
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
            printPlayerResult(name, pairs)
        }
    }

    private fun printResultAll(pairs: ResultPairs) {
        println("실행 결과")
        println(pairs.print())
    }

    private fun printPlayerResult(name: String, pairs: ResultPairs) {
        val player = pairs.findPlayer(name)
        print("실행 결과 : ")
        print(player.getReward())
    }
}
