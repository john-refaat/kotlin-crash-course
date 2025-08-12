package org.example


fun main() {
    print("Enter a number: ")
    val input = readln()
    println("You entered $input")
    val inputAsInt = input.toIntOrNull()
    val output = when (inputAsInt) {
        null -> "Not an integer"
        else ->if (inputAsInt%2==0)
            "The number is even"
        else
            "The number is odd"
        }
    println(output)
}