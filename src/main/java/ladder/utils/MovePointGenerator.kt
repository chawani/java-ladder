package ladder.utils

import ladder.domain.MovePointPair
import org.apache.commons.lang3.BooleanUtils.isTrue
import java.lang.Math.random

object MovePointGenerator {

    fun execute(playerCount: Int): List<MovePointPair> {
        val points: MutableList<MovePointPair> = mutableListOf()

        var before = false
        for (i in 1 until playerCount) {
            val judged = judgeRight(before)
            points.add(MovePointPair(before, judged))
            before = judged
        }
        points.add(MovePointPair(before, false))
        return points
    }

    private fun judgeRight(before: Boolean): Boolean {
        return if (isTrue(before)) false else ((random() * 2) >= 1)
    }
}
