
class House(type:String, price:Double, yearBuilt:Int, owner:String)
{
    var type:String? = null
    var price:Double? = null
    var yearBuilt:Int? = null
    var owner:String? = null

    init { //Initializes all our properties
        this.type = type
        this.price = price
        this.yearBuilt = yearBuilt
        this.owner = owner
    }
}

fun main(args: Array<String>) {


    var myHouse = House("3 Bedroomhouse", 23000.0, 1978, "George")
    var secondHouse = House("6 Bedroomhouse", 36000.0, 2020, "Tyler")

    myHouse.owner = "Arthur"

    println(myHouse.owner)
    println("Price: " +secondHouse.price)
}