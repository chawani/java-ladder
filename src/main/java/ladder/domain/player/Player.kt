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
}
