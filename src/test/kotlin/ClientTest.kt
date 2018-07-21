import com.github.skyshayde.Client
import java.io.File

fun main(args: Array<String>) {
    var key = File("tokens.txt").readLines()[0]
    var client = Client(key)
    client.makeUniverseRequest("5377767983284224")
    System.out.println()
}
