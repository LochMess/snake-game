package domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class BoardTest {

    @Test
    fun `should validate valid snake position within board boundaries`() {
        val snake = Snake(location = mutableListOf<Pair<Int, Int>>(Pair(1, 2)))
        assertTrue(Board(10).validBoundaries(snake))
    }

    @Test
    fun `should validate invalid snake position exceeding board boundaries`() {
        val snake = Snake(location = mutableListOf<Pair<Int, Int>>(Pair(100, 23)))
        assertFalse(Board(10).validBoundaries(snake))
    }

    @Test
    fun `should check coordinates exceed board x dimensions`() {
        val snake = Snake(location = mutableListOf<Pair<Int, Int>>(Pair(100, 5)))
        assertFalse(Board(10).validBoundaries(snake))
    }

    @Test
    fun `should check coordinates exceed board y dimensions`() {
        val snake = Snake(location = mutableListOf<Pair<Int, Int>>(Pair(1, 7)))
        assertFalse(Board(3).validBoundaries(snake))
    }

    @Test
    fun `should check coordinates within board dimensions`() {
        assertTrue(Board(3).checkCoordinate(1, 1))
    }

    @Test
    fun `should check coordinates exceed board dimensions`() {
        assertFalse(Board(3).checkCoordinate(5, 5))
    }
}