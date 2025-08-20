package properties

open class A(open val value: String) {
    init {
        // calls the getter from the subclass B which is not yet initialized
        println(value.length)
    }
}

class B(override val value: String): A(value)

open class C(val value: String) {
    init {
        println(value.length)
    }
}

// We don't override the value if we don't have to
class D(value: String): A(value)

fun main() {
    //B("a")
    D("c")
}