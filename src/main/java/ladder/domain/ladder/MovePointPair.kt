package ladder.domain.ladder

class MovePointPair(
    private val left: Boolean,
    private val right: Boolean
) {

    init {
        require(!(left && right)) { "사다리 생성 에러" }
    }

    fun canMoveLeft(): Boolean {
        return left
    }

    fun canMoveRight(): Boolean {
        return right
    }
}
