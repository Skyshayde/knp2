import com.github.skyshayde.Client
import java.io.File

fun main(args: Array<String>) {
    var key = File("tokens.txt").readLines()[0]
    var client = Client(key)
    var game = client.game("5377767983284224")
    var data = game.messages(10)
    System.out.println()
}
