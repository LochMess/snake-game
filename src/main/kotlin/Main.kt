import com.google.inject.Guice
import com.google.inject.Injector

fun main() {
    val injector: Injector = Guice.createInjector()
    val game: Game = injector.getInstance(Game::class.java)

    println("Snake game starting! Have fun!")

    game.run()
}