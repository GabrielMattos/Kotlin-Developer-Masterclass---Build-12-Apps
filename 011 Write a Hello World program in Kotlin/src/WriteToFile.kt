import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception

fun main(args: Array<String>) {

    /*println("Enter a message")
    var message = readLine().toString()
    if(message.equals(""))
    {
        println("Please enter a message")
    } else
    {
        WriteToFile(message)
    }*/

    readFile()

}

fun WriteToFile(message:String)
{
    try
    {
        var writer = FileWriter("message.txt", true)
        writer.write(message + "\n")
        writer.close()
    }

    catch(ex:Exception)
    {
        println("Exception $ex")
    }

}

fun readFile()
{
    var reader = FileReader("message.txt")
    var readMessage:String? = null
    var char:Int?

    try
    {
        do
        {
            char = reader.read()
            print(char.toChar())
        }

        while (char != -1)
    }

    catch(ex:Exception)
    {
        println("Exception $ex")
    }
}