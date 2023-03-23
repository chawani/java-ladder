package ladder.view

import ladder.domain.Players
import ladder.domain.Rewards
import java.util.*

object InputView {
    private const val MIN_HEIGHT = 1
    private const val ITEM_SPLITTER = ","
    private val NEW_LINE = System.getProperty("line.separator")
    private val scanner = Scanner(System.`in`)

    fun createPlayers(): Players {
        return try {
            println("참여할 사람 이름을 입력하세요. (이름은 ($ITEM_SPLITTER)로 구분하세요)")
            Players(readln())
        } catch (e: IllegalArgumentException) {
            OutputView.error(e)
            createPlayers()
        }
    }

    fun createRewards(playersSize: Int): Rewards {
        return try {
            println(NEW_LINE + "실행 결과를 입력하세요. (결과는 (" + ITEM_SPLITTER + ")로 구분하세요)")
            val rewards = Rewards(readln())
            validatePlayerRewardLength(playersSize, rewards.getRewardSize())
            rewards
        } catch (e: IllegalArgumentException) {
            OutputView.error(e)
            createRewards(playersSize)
        }
    }

    private fun validatePlayerRewardLength(playersSize: Int, rewardsSize: Int) {
        require(playersSize == rewardsSize) { "플레이어의 이름과 같은 갯수의 보상을 입력해주세요." }
    }

    fun inputHeight(): Int {
        return try {
            println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?")
            val height = scanner.nextLine().toInt()
            validateNaturalNumber(height)
            return height
        } catch (e: Exception) {
            OutputView.error(e)
            inputHeight()
        }
    }

    private fun validateNaturalNumber(height: Int) {
        require(height >= MIN_HEIGHT) { "사다리 높이는 최소 1 이어야 합니다." }
    }

    fun inputName(): String {
        println("\n결과를 보고 싶은 사람은?")
        return readln()
    }
}
