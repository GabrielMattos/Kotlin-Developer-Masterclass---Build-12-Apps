
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

    constructor(name:String, color:String) : this()
    {
        this.name = name
        this.color = color

        println("Third constructor: " + this.name)
        println("Third constructor: " + this.color)
    }

    fun showAnimal()
    {
        println("Name is: " + this.name)
        println("Name is: " + this.color)
        println("Name is: " + this.numLegs)
    }
}



class Lion() : Animal()
{

}

fun main(args: Array<String>) {

    //var animal = Animal("Animal", "Brown")
    var animal = Animal()
    animal.color = "Brown"
    animal.name = "Lion"
    animal.numLegs = 4

    var animal2 = Animal("Another animal", "Blue", 6)

    animal.showAnimal()
    animal2.showAnimal()

    /*var lion = Lion()
    lion.numLegs = 4

    println("Num legs " + lion.numLegs)

    //var animal = Animal("Dog", "Brown", 4)*/
}