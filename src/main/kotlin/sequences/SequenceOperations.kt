package sequences


fun m(i: Int): Int {
    print("m$i")
    return i
}

fun f(i: Int): Boolean {
    print("f$i")
    return i % 2 == 0
}

// Collections: Intermediate Collections are created on chained calls.
// Sequences: Lambdas are not inlined

fun main() {
    val list = listOf(1, 2, 3, 4)
    // Collections: Horizontal Evaluation
    list.map(::m).filter( ::f )
    println()
    // Sequences: Vertical Evaluation
    list.asSequence().map(::m).filter(::f).toList()
    println()
    // Nothing Printed because of lazy evaluation
    list.asSequence().map(::m).filter(::f)
    println()
    list.asSequence().filter(::f).map(::m).toList()
}