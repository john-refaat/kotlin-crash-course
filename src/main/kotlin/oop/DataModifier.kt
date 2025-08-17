package oop

data class Contact(val name: String, val address: String)

class Foo(val first: Int, val second: Int)
data class Bar(val first: Int, val second: Int)

data class User (val email: String) {
    // Not included in toString() or equals()
    var nickname: String? = null
}

fun main() {
    val contact = Contact("John", "75 Brazil st.")
    println(contact)
    println(contact.copy(address = "alternative address"))

    val s1 = setOf(1, 2, 3)
    val s2 = setOf(1, 2, 3)
    println(s1 == s2) // == calls equals method
    println(s1 === s2)

    println()
    val f1 = Foo(1, 3)
    val f2 = Foo(1, 3)
    println(f1 == f2) // without data modifier the default equals is trivial, compares references

    val b1 = Bar(1, 3)
    val b2 = Bar(1, 3 )
    println(b1 == b2) // With data modifier equals is generated

    val user1 = User("voldemort@gmail.com")
    user1.nickname="Voldemort"
    println(user1)

    val user2 = User("voldemort@gmail.com")
    user2.nickname="YouKnowWho"
    println(user2)

    println(user1 == user2)
}