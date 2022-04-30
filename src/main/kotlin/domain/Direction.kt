package domain

enum class Direction(val increment: Int) {
    UP(1),
    DOWN(-1),
    LEFT(-1),
    RIGHT(1);

    companion object {
        fun parse(s: String): Direction? = Direction.values().find { s.equals(it.toString(), ignoreCase = true) }
    }
}