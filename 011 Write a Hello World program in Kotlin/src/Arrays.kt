

fun main(args: Array<String>) {

    var myArray = Array<Int>(5)
    {
        2
    }

    myArray[0] = 10
    myArray[1] = 20
    myArray[2] = 30
    myArray[3] = 40
    myArray[4] = 50


    for(element in myArray)
    {
        println("Itens " + element)
    }

    println(myArray[1])
}