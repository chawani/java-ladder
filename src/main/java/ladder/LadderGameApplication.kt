package ladder

import ladder.domain.Ladder
import ladder.domain.ResultPairs
import ladder.view.InputView
import ladder.view.OutputView

fun main() {
    val players = InputView.createPlayers()
    val rewards = InputView.createRewards(players.getPlayerSize())
    val ladder = Ladder(players.getPlayerSize(), InputView.inputHeight())
    OutputView.printLadder(players, rewards, ladder)
    val resultPairs = ResultPairs(players, rewards, ladder.goDown())
    OutputView.printResult(resultPairs)
}
