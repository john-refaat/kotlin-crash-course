package lambdawithreceiver

val isEven: (Int) -> Boolean = {it % 2 == 0}
val isOdd: Int.() -> Boolean = {this % 2 == 1}

fun main() {
    val sb = StringBuilder()
    val x = with(sb) {
        appendLine("Alphabet:")
        ('a' .. 'z').iterator().forEach { append(it) }
        42
    }
    println("x = $x")


    println(sb.toString())
    println(isEven(2))
    println(1.isOdd())


    val s = buildString {
        ('A'..'Z').forEach { append(it) }
    }
    println(s)
}