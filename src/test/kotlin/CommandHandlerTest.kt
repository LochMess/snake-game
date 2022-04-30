import domain.Direction
import exceptions.CommandParseException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class CommandHandlerTest {

    @Test
    fun `should parse valid command`() {
        assertEquals(Direction.UP, CommandHandler().parseCommand("up"))
    }

    @Test
    fun `should throw exception for invalid command`() {
        assertFailsWith(CommandParseException::class) {
            CommandHandler().parseCommand("what if standard in isn't standard?")
        }
    }
}