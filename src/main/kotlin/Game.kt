import domain.Board
import domain.Direction
import domain.Snake
import exceptions.CommandParseException
import java.util.*
import javax.inject.Inject

class Game @Inject constructor(
    private val snake: Snake,
    private val board: Board,
    private val commandHandler: CommandHandler
) {

    fun run() {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNextLine()) {
            val input = scanner.nextLine()

            try {
                snake.move(commandHandler.parseCommand(input))
            } catch (e: CommandParseException) {
                println(
                    "Invalid command. Valid commands are case insensitive and one of: ${
                        Direction.values().toList().joinToString(", ")
                    }"
                )
            }
            if (!board.validBoundaries(snake)) {
                println("Game over, snake over board!")
                break
            }
            displayCurrentState()
        }
    }

    fun displayCurrentState() {
        val displayBoard = Array<CharArray>(board.dimensions) { CharArray(board.dimensions) { ' ' } }
        snake.location.forEach {
            displayBoard[it.first][it.second] = 'x'
        }
        for (column in board.dimensions - 1 downTo 0) {
            for (row in displayBoard) {
                print("|${row[column]}")
            }
            print("|\n${List(board.dimensions * 2 + 1) { '_' }.joinToString("")}\n")
        }
    }
}