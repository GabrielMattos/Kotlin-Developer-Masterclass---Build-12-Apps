//Abstract classes = not meant to be instantiated and they also
//can have a mixture of functions declared with or without an implementation

abstract class GraphicObject
{
    fun moveTo(newX:Int, newY:Int)
    {
        println("Move to new x and new y")
    }

    abstract fun draw()
    abstract fun resize()
}

class Circle: GraphicObject()
{
    override fun draw() {
        println("Drawing circle")
    }

    override fun resize() {
        println("Resizing circle")
    }
}

class Triangle: GraphicObject()
{
    override fun draw() {
        println("Drawing triangle")
    }

    override fun resize() {
        println("Resizing triagle")
    }
}


fun main(args: Array<String>) {

    var circle = Circle()
    circle.draw()
    circle.resize()
    circle.moveTo(10, 30)

    var triangle = Triangle()
    triangle.draw()
    triangle.resize()  
}