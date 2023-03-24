package ladder.domain.player

import ladder.domain.excutor.Direction
import ladder.domain.ladder.MovePointPair

class Player(
    val name: String,
    var index: Int
) {

    fun move(movePointPairs: List<MovePointPair>) {
        index = Direction.determine(movePointPairs[index]).move(index)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Player) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
