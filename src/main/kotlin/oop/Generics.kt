package oop

fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    println("myFilter")
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) destination.add(element)
    }
    return destination
}

// Non-nullable upper bound
fun <T: Any> foo(list: List<T>) {
    for (element in list) {
        println(element)
    }
}

// Nullable Number upperbound
fun <T : Number?> oneHalf(value: T): Double? {
    if (value == null) return null
    return value.toDouble() / 2.0
}

fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T) where T: CharSequence, T: Appendable {
    if (!seq.endsWith('.'))
        seq.append('.')
}

fun List<Int>.myAvg(): Double {
    return this.sum().toDouble() / this.count()
}

@JvmName("avgOfDouble")
fun List<Double>.myAvg(): Double {
    return this.sum().toDouble() / this.count()
}

fun main() {
    println(listOf(1, 2, 3, 4, 5, 6, 7).myFilter { it % 2 == 0 })
    val strings = listOf("Sandy", "Lilly", "Rebecca", "Sonam", null)
    val filtered: List<String?> = strings.myFilter { it?.startsWith("S") ?: false }
    val filteredNotNull: List<String> = strings.filterNotNull().myFilter { it.startsWith("S") }
    println(filtered)
    println(filteredNotNull)
    //foo(listOf("hello", null))
    foo(listOf("hello", "bye"))

    println(oneHalf(5))
    println(oneHalf(null))

    println(max(2, 3))
    val helloWorld = StringBuilder("Hello, World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

}
