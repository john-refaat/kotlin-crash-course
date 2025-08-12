package general

fun main() {
    print("Enter Index: ")
    val input = readln()
    val inputAsInteger = input.toIntOrNull()
    val favouriteNumbers = intArrayOf(1,2,3,5,8)
    if (inputAsInteger != null && inputAsInteger in 0..favouriteNumbers.lastIndex) {
        println("Your Number is ${favouriteNumbers[inputAsInteger]}")
    } else {
        println("That index does not exist")
    }

}