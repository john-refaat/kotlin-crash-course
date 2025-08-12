package oop

class Person(val name: String, val age: Int) {
    val nickname: String = "$name$age"
    init {
        println("Person $name $age (${this.nickname})")
    }
}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4

    protected class Nested {
        public val e: Int = 5
    }
}

open class Parent(val name: String)
class Child: Parent {
    constructor(name: String, param: Int): super(name)
}


class Subclass: Outer() {
    override val b = 5
    override val c = 7

    fun foo() {
        val nested = Outer.Nested()
        println("Subclass b: $b")
        println("Subclass c: $c")
        println("Subclass d: $d")
        println("Subclass e: ${nested.e}")
        println(nested)
    }
}

class Unrelated(var o: Outer) {

    fun foo() {
        println("Unrelated c = ${o.c}")
        println("unrelated d = ${o.d}")
    }
}

class InternalComponent
internal constructor(name: String) {
    val name: String = name+"_"
    init {
        println(this.name)
    }
}

fun main() {
    Person("John", 36)
    InternalComponent("mycomponent")
    val outer = Outer()
    val subclass = Subclass()
    subclass.foo()
    val unrelated = Unrelated(outer)
    unrelated.foo()
}
