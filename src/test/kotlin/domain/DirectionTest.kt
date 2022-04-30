package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class DirectionTest {

    @Test
    fun `should parse string to direction`() {
        assertEquals(Direction.RIGHT, Direction.parse("riGHt"))
    }

    @Test
    fun `should give null for string that doesn't match direction`() {
        assertNull(Direction.parse("Lorem ipsum dolor sit amet"))
    }
}