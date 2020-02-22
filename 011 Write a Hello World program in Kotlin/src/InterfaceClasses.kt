//Interface classes = classes that have methods without bodies
interface InputHandler
{
    fun clicked()
    fun doubleClicked()
    fun singleClicked()
}
class Phone: InputHandler
{
    override fun clicked()
    {
        println("Phone clicked")
    }

    override fun doubleClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun singleClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
class Button: InputHandler
{
    override fun clicked()
    {
        println("Button clicked")
    }

    override fun doubleClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun singleClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main(args: Array<String>) {

    var myButton = Button()
    myButton.clicked()

    var myPhone = Phone()
    myPhone.singleClicked()

}
