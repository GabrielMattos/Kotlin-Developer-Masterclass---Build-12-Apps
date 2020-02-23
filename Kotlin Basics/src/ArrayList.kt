

fun main(args: Array<String>) {

    var myArrayList = ArrayList<String>()
    myArrayList.add("James")
    myArrayList.add("Paul")
    myArrayList.add("Hagrid")
    myArrayList.set(1, "Rubeo")

    if(myArrayList.contains("Hagrid"))
    {
        println("Harry!")
    }

    myArrayList.remove("Paul")

    //println(" " + myArrayList.get(0))

    for(names in myArrayList)
    {
        //println("Names: " + names)
    }

    for(index in 0..myArrayList.size - 1)
    {
        println("Items: " + myArrayList.get(index))
    }
}