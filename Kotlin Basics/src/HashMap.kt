
fun main(args: Array<String>) {

    //Hashmap - key-value pairs

    var hashmap = HashMap<String, String>()
    hashmap.put("Mary", "Married")
    hashmap.put("Paulo", "Married")
    hashmap.put("Josh", "Single")

    for(key in hashmap.keys)
    {
        println(hashmap.get(key))
    }

    //println(hashmap.get("Mary"))
}