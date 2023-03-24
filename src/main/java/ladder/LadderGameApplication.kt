package ladder

import ladder.domain.Ladder
import ladder.domain.ResultPairs
import ladder.view.InputView
import ladder.view.OutputView

fun main() {
    val players = InputView.createPlayers()
    val rewards = InputView.createRewards(players.size)

    val ladder = Ladder(players.size, InputView.inputHeight())
    OutputView.printLadder(players, rewards, ladder)

    val resultPairs = ResultPairs(players, rewards, ladder)
    OutputView.printResult(resultPairs)
}
