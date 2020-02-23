fun main(args: Array<String>) {

    //Default is alwys immutable
    var myArrayList = listOf<String>("Me", "James", "Bonni", "Car")
    //println(myArrayList[0])

    //Make it mutable
    var myMutableList = mutableListOf<String>("Me", "James", "Bonni", "Car")
    myMutableList[0] = "Gabriel"

    //Hashmap
    var myHashmap = hashMapOf(1 to "Paulo", 2 to "James")
    println(myHashmap.get(1))

    //Array
    var myArray = arrayOf(1, 4, 8, 10)
    myArray[0] = 3

    for(items in myArray)
    {
        println("Items $items")
    }
}