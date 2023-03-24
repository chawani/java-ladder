package ladder.domain

class PointPair(
    private val left: Boolean,
    private val right: Boolean
) {

    fun canMoveLeft(): Boolean {
        return left
    }

    fun canMoveRight(): Boolean {
        return right
    }
}
