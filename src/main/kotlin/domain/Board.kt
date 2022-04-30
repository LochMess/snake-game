package domain

data class Board(
    val dimensions: Int = 10
) {
    fun checkCoordinate(x: Int, y: Int): Boolean {
        if (x < 0 || x > dimensions) return false
        if (y < 0 || y > dimensions) return false
        return true
    }

    fun validBoundaries(snake: Snake): Boolean {
        snake.location.forEach { if (!checkCoordinate(it.first, it.second)) return false }
        return true
    }
}