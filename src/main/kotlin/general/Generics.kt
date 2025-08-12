package org.example

fun main() {
    val favouriteNumbers = listOf(1,2,3,4,5)
    val stringList = listOf("Hello World!",
        "Bye-bye!",
        "How's it going?")

    val filteredNumbers =  favouriteNumbers.myFilter {
        it < 3
    }
    println(filteredNumbers)

    val filteredStrings = stringList.myFilter {
        it.length > 10
    }
    println(filteredStrings)

}

fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result.toList()
}

fun makeNetworkCall(): Result<Int, String> {
    return Result.Success(200)
}

fun makeFunnyNetworkCall(): Result<Int, String> {
    return Result.Failure("Invalid Call!")
}

sealed interface Result<out D, out E> {
    data class Success<D>(val data: D): Result<D, Nothing>
    data class Failure<E>(val error: E): Result<Nothing, E>

}
