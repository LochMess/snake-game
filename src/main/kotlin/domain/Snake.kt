package domain

import exceptions.SnakeSelfCollisionException

data class Snake(
    val location: MutableList<Pair<Int, Int>> = mutableListOf(
        2 to 0,
        1 to 0,
        0 to 0
    ),
    private var steps: Int = 0
) {
    private val head: Pair<Int, Int>
        get() = location.first()

    fun selfCollision(): Boolean {
        for (index in 1 until location.size) {
            val segment = location[index]
            if (segment.first == head.first && segment.second == head.second) return true
        }
        return false
    }

    fun move(direction: Direction) {
        steps++
        when (direction) {
            Direction.UP, Direction.DOWN -> {
                location.add(
                    index = 0,
                    Pair(head.first, head.second + direction.increment)
                )
            }
            Direction.LEFT, Direction.RIGHT -> {
                location.add(
                    index = 0,
                    Pair(head.first + direction.increment, head.second)
                )
            }
        }
        if (steps % 5 != 0) location.removeLast()
        if (selfCollision()) throw SnakeSelfCollisionException("Game over your snake collided with itself.")
    }
}