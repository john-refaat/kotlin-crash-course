package sequences

val numbers = sequence {
    var x = 0
    while(true)
        yield(x++)
}

fun mySequence() = sequence {
    println("yield one element")
    yield(1)
    println("yield a range")
    yieldAll(3..5)
    println("yield a list")
    yieldAll(listOf(7, 9))
}

fun fibonacci(): Sequence<Int> = sequence {
    var a = 0
    var b = 1
    yield(a)
    while (true) {
        yield(b)
        val temp = b
        b = a + b
        a = temp
    }
}

data class Person(val id: Int, val name: String, val age: Int, val isPublicProfile: Boolean)

fun main() {
    for (i in numbers.take(10)) {
        print("$i ")
        Thread.sleep(100)
        if (i%10==0) println()
    }
    println()
    println(mySequence().map {
        print("$it ")
        it * it }
        .filter {
            print("$it ")
            it > 10 }
        .first())
    println()
    println(fibonacci().take(10).toList())

    val people = listOf(
        Person(1, "Alice", 28, true),
        Person(2, "Bob", 34, false),
        Person(3, "Charlie", 22, true),
        Person(4, "Diana", 45, true),
        Person(5, "Ethan", 19, false),
        Person(6, "Fiona", 28, true),
        Person(7, "George", 34, true),
        Person(8, "Hannah", 22, false),
        Person(9, "Ian", 28, false),
        Person(10, "Jane", 34, true)
    )

    val list = people.mapNotNull { p -> p.takeIf { it.isPublicProfile }?.name }
    println(list)

    val map = people.groupBy { it.age }.mapValues { (_, value) -> value.map { it.name } }
    println(map)

    val map2 = mutableMapOf<Int, MutableList<Person>>()
    for (p in people) {
        map2.getOrPut(p.age) { mutableListOf() }.add(p)

    }
    val map3 = map2.mapValues { (_, value) -> value.map { it.name } }
    println(map3)

    println(people.groupingBy { it.age }.eachCount())

    println(people.asSequence().groupBy { it.age }.mapValues { (_, value) -> value.map { it.name } })

}