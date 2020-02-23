import java.io.FileWriter
import java.lang.Exception

fun main(args: Array<String>) {

    var message = "klkwgkjljwkljwnwoiw iuonwuwngklnw lknkwnglknlkenklerlklneer"
    WriteToFile(message)
}

fun WriteToFile(message:String)
{
    try
    {
        var writer = FileWriter("message.txt")
        writer.write(message)
        writer.close()
    }

    catch(ex:Exception)
    {
        println("Exception $ex")
    }

}