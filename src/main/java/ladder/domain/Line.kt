package ladder.domain

import ladder.dto.PointsTupleDto

class Line(private val canMoveForLines: List<PointsTuple>) {
    init {
        require(!isConsecutive(canMoveForLines))
    }

    private fun isConsecutive(canMoveForLines: List<PointsTuple>): Boolean {
        return canMoveForLines.contains(PointsTuple(mutableListOf(true, true)))
    }

    fun determineDirection(position: Int): Direction {
        return Direction.determine(canMoveForLines[position])
    }

    fun makeTupleDto(): List<PointsTupleDto> {
        return canMoveForLines.map { PointsTupleDto(it.canMoveRight()) }
    }
}
