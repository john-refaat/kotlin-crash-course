package types

import oop.key

val kotlinToJavaTypes = mapOf(
    "Int" to "int",
    "Double" to "double",
    "Boolean" to "boolean",
    "Int?" to "java.lang.Integer",
    "Double?" to "java.lang.Double",
    "Boolean?" to "java.lang.Integer",
    "List<Int>" to "List<Integer>",
    "Array<Int>" to "Integer[]",
    "Array<Int>" to "Integer[]",
    "IntArray" to "int[]",
    "kotlin.String" to "java.lang.String",
    "Any" to "java.lang.Object",
    "() -> Boolean" to "Function0<Boolean>",
    "(Order) -> Int" to "Function1<Order, Int>",
    "(Int, Int) -> Int" to "Function1<Int, Int, Int>",
    "Unit" to "void",
    "Nothing" to "void"
)
// Unit: A type that allows only one value and thus can hold no information.
// Unit return type: function completes normally
// Nothing: A type that has no values.
// Nothing type means: "This function Never returns" (for example throws exception)
// Nothing return type: Function completes abnormally or never completes (inf loop)

fun main() {
    // Calling invoke explicitly
    val f: (() -> Int) = {146}
    println(f.invoke())
    println(f())

    //val g: (() -> Int)? = null
    val g: (() -> Int)? = {23456}
    println(g?.invoke())

    // Array Comparison in Kotlin
    // Prefer Lists to Arrays
    val ints1 = intArrayOf(1, 2)
    val ints2 = intArrayOf(1, 2)
    println(ints1 == ints2)
    println(ints1.equals(ints2))
    println(ints1.contentEquals(ints2))

    val col1Width = 20
    val col2Width = 20

    println(String.format("%-${col1Width}s %-${col2Width}s", "Kotlin", "Java"))
    println("=".repeat(col1Width + col2Width + 1))

    kotlinToJavaTypes.forEach { (key, value) ->
        println(String.format("%-${col1Width}s %-${col2Width}s", key, value))
    }
}
