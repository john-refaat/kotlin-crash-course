package general

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}


fun duplicateNonZeroes(list: List<Int>): List<Int> {
    return list.filter { it != 0 }
        .flatMap {
            //if (it == 0) return listOf() Will return empty list from the whole fun
            listOf(it, it)
    }
}

fun duplicateNonZeroes2(list: List<Int>): List<Int> {
    return list.flatMap l@{
        if (it == 0) return@l listOf()
        listOf(it, it)
    }
}

//Anonymous function
fun duplicateNonZeroes3(list: List<Int>): List<Int> {
    return list.flatMap (
        fun(e): List<Int> {
            if (e == 0)
                return listOf()
            return listOf(e, e)
        }
    )
}

fun duplicateNonZeroes4(list: List<Int>): List<Int> {
    return list.flatMap {
            if (it == 0)
                listOf()
            else
                listOf(it, it)
        }

}

fun String.isNice(): Boolean {
    val noBadSubstring = setOf("ba", "be", "bu").none {it in this}
    val hasThreeVowels = count {
        it in "aeiou"
    } >= 3
    val hasDouble = this.zipWithNext().any { it.first == it.second }
    // (0 until lastIndex).any {this[it] == this[it + 1]}
    //windowed(2).any{it[0] == it[1]}
    return listOf(noBadSubstring, hasThreeVowels, hasDouble).count { it } >= 2
}

fun String?.isEmptyOrNull(): Boolean = this == null || isEmpty()

fun main() {
    val isEven : (Int) -> Boolean = {it % 2 == 0}
    println(isEven)
    println(isEven(4))

    fun isOdd(i:Int) = i%2==0
    println(isOdd(3))

    val odd = ::isOdd
    val even = isEven
    println(odd)
    println(even)

    // Non-bound reference
    val agePredicate: (Person, Int) -> Boolean = Person::isOlder
    val alice = Person("Alice", 29)
    println(agePredicate)
    println(agePredicate(alice, 21))

    // Bound reference
    val bob = Person("Bob", age = 28)
    val bobAgePredicate: (Int) -> Boolean = bob::isOlder
    println(bobAgePredicate)
    println(bobAgePredicate(21))

    val list = listOf(3, 0, 5)
    println(duplicateNonZeroes(list))
    println(duplicateNonZeroes2(list))
    println(duplicateNonZeroes3(list))
    println(duplicateNonZeroes4(list))

    val text = "Hippopotamus"
    println(text.zipWithNext())
    println(text.isNice())

    val badString = "bee"
    println(badString.isNice())
    println("be" in "bees")
}