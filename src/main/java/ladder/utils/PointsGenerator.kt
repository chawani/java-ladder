package ladder.utils

import ladder.domain.PointPair
import org.apache.commons.lang3.BooleanUtils.isTrue
import java.lang.Math.random

object PointsGenerator {

    fun generate(countOfPlayer: Int): List<PointPair> {
        val points: MutableList<PointPair> = mutableListOf()

        var before = false
        for (i in 0 until countOfPlayer - 1) {
            val judged = judgeRight(before)
            points.add(PointPair(before, judged))
            before = judged
        }
        points.add(PointPair(before, false))
        return points
    }

    private fun judgeRight(before: Boolean): Boolean {
        return if (isTrue(before)) false else ((random() * 2) >= 1)
    }
}
