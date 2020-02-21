
open class Animal()
{
    var name:String? = null
    var color:String? = null
    var numLegs:Int? = null

    constructor(name:String, color:String, numLegs:Int) : this()
    {
        this.name = name
        this.color = color
        this.numLegs = numLegs

        println("Object: " + this.name)
        println("Object: " + this.color)
        println("Object: " + this.numLegs)
    }
}

class Lion() : Animal()
{

}

fun main(args: Array<String>) {

    var lion = Lion()
    lion.numLegs = 4

    println("Num legs " + lion.numLegs)

    //var animal = Animal("Dog", "Brown", 4)
}