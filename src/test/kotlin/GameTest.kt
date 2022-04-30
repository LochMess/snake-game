import domain.Board
import domain.Direction
import domain.Snake
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

internal class GameTest {

    private val standardIn = System.`in`
    private val standardOut = System.out

    private val snake = mock<Snake>()
    private val board = mock<Board>()
    private val commandHandler = mock<CommandHandler>()

    @AfterEach
    fun fixUp() {
        System.setIn(standardIn)
        System.setOut(standardOut)
        reset(snake, board, commandHandler)
    }

    @Test
    fun `should run game`() {
        val game = Game(snake, board, commandHandler)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        doNothing().`when`(snake).move(any())
        stubbing(snake) {
            on(it.location) doReturn mutableListOf(Pair(1, 1))
        }
        stubbing(commandHandler) {
            on(it.parseCommand(any<String>())) doReturn Direction.RIGHT
        }
        stubbing(board) {
            on(it.validBoundaries(snake)) doReturn true
            on(it.dimensions) doReturn 3
        }

        val inputStream = ByteArrayInputStream("right".toByteArray())
        System.setIn(inputStream)

        game.run()

        assertEquals(
            """
            \| | | |
            \_______
            \| |x| |
            \_______
            \| | | |
            \_______""".trimMargin("\\"),
            outputStream.toString().trim()
        )
    }
}