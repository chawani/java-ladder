package ladder.domain

enum class Direction(private val direction: Int) {

    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    fun move(position: Int): Int {
        return position + direction
    }

    companion object {
        fun determine(tuple: PointsTuple): Direction {
            if (tuple.canMoveRight()) return RIGHT
            return if (tuple.canMoveLeft()) LEFT else STRAIGHT
        }
    }
}
