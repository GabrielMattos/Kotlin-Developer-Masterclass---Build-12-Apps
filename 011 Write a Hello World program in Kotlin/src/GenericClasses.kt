
class Login<T>(name: T, password: T)
{
    init
    {
        println("Name: " + name + " password: " + password)
    }
}

class Person(username:String, password:String)
{
    var username:String? = null
    var password:String? = null


    init
    {
        this.username = username
        this.password = password
    }
}


fun main(args: Array<String>) {

    var login = Login<String>("Gabriel", "123456")
    var login_2 = Login<Int>(12, 10)
    var login_3 = Login<Boolean>(true, false)

    var person = Person("Gabriel", "123456")
    var user = Login<Person>(person, person)
}