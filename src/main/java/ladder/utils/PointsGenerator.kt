package ladder.utils

import ladder.domain.PointsTuple
import org.apache.commons.lang3.BooleanUtils
import java.util.*

class PointsGenerator(private val countOfPlayer: Int) {

    private var before = false

    fun generate(): List<PointsTuple> {
        before = false
        val points: MutableList<PointsTuple> = ArrayList<PointsTuple>()
        for (i in 0 until countOfPlayer - 1) {
            points.add(PointsTuple(makeRandomTuple()))
        }
        points.add(PointsTuple(Arrays.asList(before, false)))
        return points
    }

    private fun makeRandomTuple(): List<Boolean> {
        return Arrays.asList(before, validRandom())
    }

    private fun validRandom(): Boolean {
        return if (BooleanUtils.isTrue(before)) {
            false.also { before = it }
        } else randomBoolean()
    }

    private fun randomBoolean(): Boolean {
        return ((Math.random() * 2).toInt() > 0).also { before = it }
    }
}
