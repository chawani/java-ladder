package ladder.domain.ladder

import ladder.utils.MovePointGenerator

class Ladder(
    playerCount: Int,
    height: Int
) {

    val lines: MutableList<Line> = mutableListOf()

    init {
        for (i in 0 until height) {
            lines.add(Line(MovePointGenerator.execute(playerCount)))
        }
    }
}
