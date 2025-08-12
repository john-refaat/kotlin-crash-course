package org.example

import kotlin.text.iterator

fun main() {
    print("Enter a String: ")
    val input = readln()
    val lettersOnly = input.filter { it.isLetter() }
    println(lettersOnly)
    print(input.myFilter { isLetter() })
}

fun String.myFilter(predicate: Char.()-> Boolean): String {
    return buildString {
        for (char in this@myFilter) {
            if (char.predicate()) {
                append(char)
            }
        }
    }
}