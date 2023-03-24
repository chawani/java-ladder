package ladder.domain

import ladder.utils.PointsGenerator
import java.util.stream.IntStream.range
import kotlin.streams.toList

class Ladder(numPlayers: Int, height: Int) {

    private val numPlayers: Int
    val lines: MutableList<Line> = ArrayList()

    init {
        this.numPlayers = numPlayers
        for (i in 0 until height) {
            lines.add(Line(PointsGenerator.generate(numPlayers)))
        }
    }

    fun goDown(): ResultIndex {
        var indices = range(0, numPlayers).toList()
        for (line in lines) {
            indices = goingDownOneLine(indices, line)
        }
        return ResultIndex(indices)
    }

    private fun goingDownOneLine(indices: List<Int>, line: Line): List<Int> {
        val tempIndex: MutableList<Int> = mutableListOf()
        for (i in indices.indices) {
            tempIndex.add(line.moveToDirection(indices[i]))
        }
        return tempIndex
    }
}
