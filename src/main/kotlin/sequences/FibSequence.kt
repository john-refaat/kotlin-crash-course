package sequences

fun fibonacci2(): Sequence<Int> = sequence{
    var elements = 0 to 1

    while(true) {
        yield(elements.first)
        elements = elements.second to (elements.first + elements.second)
    }
}

fun main() {
    println(fibonacci2().take(10).toList())
}