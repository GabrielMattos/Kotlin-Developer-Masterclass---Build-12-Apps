
//var myName = "Elliot" //Global variable
var myName:String? = null


fun main(args: Array<String>) {

    //var myname --> local variable
    myName

    showName("James")
}

fun showName(name:String)
{
    myName = "Bonni"
    println("Name: $myName")
}