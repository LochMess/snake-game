import domain.Direction
import exceptions.CommandParseException

class CommandHandler {
    fun parseCommand(userInput: String): Direction {
        return Direction.parse(userInput) ?: throw CommandParseException("Your input could not be parsed to a command")
    }
}