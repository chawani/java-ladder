package ladder.domain

class PointsTuple(points: List<Boolean>) {

    private val left: Boolean
    private val right: Boolean

    init {
        require(points.size == 2)
        left = points[0]
        right = points[1]
    }

    fun canMoveRight(): Boolean {
        return right
    }

    fun canMoveLeft(): Boolean {
        return left
    }
}
