package ladder.view

import ladder.domain.player.Player
import ladder.domain.player.Players
import ladder.domain.reward.Reward
import ladder.domain.reward.Rewards
import ladder.utils.Validator

object InputView {

    private const val ITEM_SPLITTER = ","

    fun createPlayers(): Players {
        return try {
            println("참여 할 사람 이름을 입력하여라. (($ITEM_SPLITTER)로 구분)")
            val inputs = readln().split(ITEM_SPLITTER)
            Validator.validNames(inputs)
            var count = 0
            Players(inputs.map { Player(it, count++) })
        } catch (e: IllegalArgumentException) {
            OutputView.error(e)
            createPlayers()
        }
    }

    fun createRewards(playerCount: Int): Rewards {
        return try {
            println("\n실행 결과를 입력하여라. (($ITEM_SPLITTER)로 구분)")
            val inputs = readln().split(ITEM_SPLITTER)
            Validator.validatePlayerAndRewardCount(playerCount, inputs.size)
            Validator.validRewards(inputs)
            Rewards(inputs.map { Reward(it) })
        } catch (e: IllegalArgumentException) {
            OutputView.error(e)
            createRewards(playerCount)
        }
    }

    fun inputHeight(): Int {
        return try {
            println("\n최대 사다리 높이는?")
            val height = readln().toInt()
            Validator.validateNaturalNumber(height)
            return height
        } catch (e: Exception) {
            OutputView.error(e)
            inputHeight()
        }
    }

    fun inputName(): String {
        println("결과를 보고 싶은 사람은?")
        return readln()
    }
}
