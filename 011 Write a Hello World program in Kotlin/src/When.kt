fun main(args: Array<String>) {

    println("Enter a number between 1 - 10")
    var enteredNumber = readLine()!!.toInt()

    when(enteredNumber)
    {
        1 -> println("Wrong number")
        2 -> println("Getting close!")
        3 -> println("Closer")
        4 -> println("Humm..")
        5 -> println("Well, you are lost!")
        6 -> println("Bingo!")

        else ->
        {
            println("Sorry")
        }
    }

    /*var age:Int = 19

    when(age)
    {
        17 -> println("17")
        18 -> println("18")
        19 -> println("Yep 19!")
        else ->
        {
            println("None of the above")
        }
    }*/
}