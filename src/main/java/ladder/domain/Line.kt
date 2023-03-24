package ladder.domain

import ladder.dto.PointsTupleDto

class Line(private val canMoveForLines: List<PointPair>) {

    init {
        require(!isConsecutive(canMoveForLines))
    }

    private fun isConsecutive(canMoveForLines: List<PointPair>): Boolean {
        return canMoveForLines.contains(PointPair(true, true))
    }

    fun moveToDirection(position: Int): Int {
        return Direction.determine(canMoveForLines[position]).move(position)
    }

    fun makeTupleDto(): List<PointsTupleDto> {
        return canMoveForLines.map { PointsTupleDto(it.canMoveRight()) }
    }
}
