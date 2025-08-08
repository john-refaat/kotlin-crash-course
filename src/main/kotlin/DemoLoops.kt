package org.example

fun main() {
    val maps = mapOf(1 to "One",
        2 to "Two",
        3 to "Three")
    for ((key, value) in maps) {
        println("$key -> $value")
    }

    val list = listOf("a", "b", "c")
    for (pair in list.withIndex()) {
        println("${pair.index}: ${pair.value}")
    }
    for (i in 1..9) {
        print("$i ")
    }
    println()
    for (i in 1 until 9)
        print("$i ")

    println()
    for (i in 9 downTo 1 step 2 )
        print("$i ")

    println()
    for (c in '0' until '9')
        print("${c+1} ")
    println()

    println(recognize('J'))
    println(recognize('$'))
    println(recognize('7'))

    println("Kotlin" in "Java".."Scala")
    println("ball" in "a".."k")
}

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "Digit"
    in 'a' .. 'z', in 'A'..'Z' -> "Letter"
    else -> "Unrecognizable"
}