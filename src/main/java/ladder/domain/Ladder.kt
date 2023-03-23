package ladder.domain

import ladder.utils.PointsGenerator
import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

class Ladder(numPlayers: Int, height: Int) {

    private val numPlayers: Int
    val lines: MutableList<Line> = ArrayList()

    init {
        val generator = PointsGenerator(numPlayers)
        this.numPlayers = numPlayers
        for (i in 0 until height) {
            lines.add(Line(generator.generate()))
        }
    }

    fun goDown(): ResultIndex {
        var indices = IntStream.range(START, numPlayers).boxed().collect(Collectors.toList())
        for (line in lines) {
            indices = goDownOneLine(indices, line)
        }
        return ResultIndex(indices)
    }

    companion object {
        private const val START = 0
        fun goDownOneLine(indices: List<Int>, line: Line): List<Int> {
            val tempIndex = IntArray(indices.size)
            for (i in indices.indices) {
                tempIndex[i] = line.determineDirection(indices[i]).move(indices[i])
            }
            return Arrays.stream(tempIndex).boxed().collect(Collectors.toList())
        }
    }
}
