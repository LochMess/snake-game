package domain

import exceptions.SnakeSelfCollisionException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class SnakeTest {

    @Test
    fun `should move snake in provided direction`() {
        val snake = Snake()
        snake.move(Direction.UP)
        assertEquals(
            listOf(Pair(2, 1), Pair(2, 0), Pair(1, 0)),
            snake.location
        )
    }

    @Test
    fun `should increment snake length on fifth step`() {
        val snake = Snake()

        for (step in 1..5) {
            assertEquals(3, snake.location.size)
            snake.move(Direction.UP)
        }

        assertEquals(
            4,
            snake.location.size
        )
    }

    @Test
    fun `should throw exception if snake hits itself`() {
        assertFailsWith(SnakeSelfCollisionException::class) {
            val snake = Snake()
            snake.move(Direction.LEFT)
        }
    }
}