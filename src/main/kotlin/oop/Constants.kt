package oop

//compile-time constant (inline)
const val answer = 42
const val key = "secret"

// const can be only used with primitive types and strings
// const val invalidConst = Customer("Fred")

data class MyClass(val name: String)

//Exposes the property as a static field without a getter
@JvmField
val prop = MyClass("my class")

object MyObject {
    val prop = MyClass("prop in MyObject")

    @JvmStatic
    val answer = 42

    @JvmField
    val myField = "Life, Universe, and everything!"
}

class Bee {
    @JvmField
    val prop = MyClass("prop in Bee")
}


fun main() {
    println(MyObject.prop)
    println(Bee().prop)
}