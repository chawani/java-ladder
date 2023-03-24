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
            println("참여할 사람 이름을 입력하세요. (이름은 ($ITEM_SPLITTER)로 구분하세요)")
            val inputs = readln().split(",")
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
            println("\n실행 결과를 입력하세요. (결과는 ($ITEM_SPLITTER)로 구분하세요)")
            val inputs = readln().split(",")
            Validator.validatePlayerAndRewardCount(playerCount, inputs.size)
            Rewards(inputs.map { Reward(it) })
        } catch (e: IllegalArgumentException) {
            OutputView.error(e)
            createRewards(playerCount)
        }
    }

    fun inputHeight(): Int {
        return try {
            println("\n최대 사다리 높이는 몇 개인가요?")
            val height = readln().toInt()
            Validator.validateNaturalNumber(height)
            return height
        } catch (e: Exception) {
            OutputView.error(e)
            inputHeight()
        }
    }

    fun inputName(): String {
        println("\n결과를 보고 싶은 사람은?")
        return readln()
    }
}
