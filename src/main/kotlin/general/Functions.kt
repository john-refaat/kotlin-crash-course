package org.example

fun main() {
    print("Enter a String: ")
    var input = readln()
    while (input != "quit") {
        val rev = input.reversed()
        println(rev)
        if (input == rev)
            println("That is a palindrome!")
        print("Enter a String: ")
        input = readln()
    }
}

fun String.reversed(): String {
    return buildString {
        for (i in this@reversed.lastIndex downTo 0)
            append(this@reversed[i])
    }
}