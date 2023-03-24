package ladder.domain.ladder

class Line(
    val movePointPairs: List<MovePointPair>
) {

    fun moveJudgments(): List<Boolean> {
        return movePointPairs.map { it.canMoveRight() }.subList(0, movePointPairs.size - 1)
    }
}
