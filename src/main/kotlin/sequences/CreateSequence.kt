package sequences

import kotlin.random.Random

fun main() {
    val seq = generateSequence { Random.nextInt(5).takeIf { it > 0 } }
    println(seq.toList())

    // Reading Input
//    val input = generateSequence { readLine().takeIf { it != "exit" } }
//    println(input.toList())

    // Infinite Sequence
    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())

    val fibonacci = generateSequence(0 to 1) { (prev, current) -> current to (prev + current) }
        .map {(i, _)-> i}
    println(fibonacci.take(10).toList())

    val nums = generateSequence(3) {
        n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7 }
    }
    println(nums.first())
    println(nums.toList())
}