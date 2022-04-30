package exceptions

class CommandParseException(override val message: String) : RuntimeException(message)