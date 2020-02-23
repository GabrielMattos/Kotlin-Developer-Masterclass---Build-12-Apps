fun main(args: Array<String>) {

    var isTrue:Boolean? = false

    do
    {
        println("How many siblings does Paulo have?")
        var answer:Int? = readLine()!!.toInt()

        when(answer)
        {
            12 -> {
                println("CORRECT!")
                isTrue = true
            }

            else -> println("INCORRECT!")
        }
    }

    while (isTrue == false)
    {

    }
}