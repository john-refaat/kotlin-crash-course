package properties

val lazyValue: String by lazy {
    println("Computed!")
    "Hello"
}

fun main() {
    println(lazyValue)
    println(lazyValue)
}