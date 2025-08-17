package oop

open class Parent2 {
    open val foo = 1
    init {
        //calls the get method from the child object
        //where the foo field is not initialized yet
        println("foo: $foo")
    }
}

class Child2: Parent2() {
    override val foo = 2
}

fun main() {
    val child = Child2()
    println(child.foo)
}