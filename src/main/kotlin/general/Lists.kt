package general

fun main() {
    print("Number of integers: ")
    val n = readln().toIntOrNull() ?: 0
    var i = 0
    var sum = 0
    val numbers = mutableListOf<Int>()
    while (i < n) {
        print("Enter #${i+1}: ")
        val num = readln().toIntOrNull() ?: continue
        numbers.add(num)
        sum += num
        i++
    }
    println("Your Numbers: $numbers")
    println("The sum is $sum")
}