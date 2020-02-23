//Enum classes = allow us to represent collection of information
//fixed or static information

enum class Suits
{
    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBS
}

enum class Direction
{
    NORTH,
    SOUTH,
    EAST,
    WEST
}

fun main(args: Array<String>) {

    var cardPlayer = Suits.DIAMONDS
    var cardPlayer_2 = Suits.CLUBS


    if(cardPlayer == Suits.DIAMONDS)
    {
        println("OK")
    }

    if(cardPlayer == Suits.CLUBS)
    {
        println("OK 2")
    }

    var playerDirection = Direction.EAST
    if(playerDirection == Direction.EAST)
    {
        println("Go to EAST")
    }
}